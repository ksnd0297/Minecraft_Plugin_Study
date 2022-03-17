package calculator;

import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Recursive Descent Parser of simple expression
 * 
 * EBNF of our grammar <command> -> <expr>\n <expr> -> <term> {+ <term>}
 * <term>-> <factor> {* <factor>} <factor> -> <number> | (<expr>) <number> ->
 * <digit>{<digit>} <digit> -> 0|1|2|3|4|5|6|7|8|9
 * 
 * 
 * @author Jangwu Jo
 *
 */
public class Calculator {

	int token, ch;
	private PushbackInputStream input;
	public boolean compare; // 논리연산 일때는 true 또는 false로 출력

	public Calculator(PushbackInputStream is) {
		input = is;
	}

	void error() {
		System.out.printf("parse error : %d\n", token);
		System.exit(1);
	}

	void command() {
		/* command -> expr '\n' */
		String ans = checkStr(expr());
		if (!compare) {
			System.out.println(ans);
			return;
		} else if (compare) {
			if (ans.equals("0")) {
				System.out.println("false");
				return;
			}

			else {
				System.out.println("true");
				return;
			}
		}

		if (token == '\n') /* end the parse and print the result */ {
		} else {
			error();
		}
	}

	String checkStr(String ret) { // false나 true와 같은 연산은 일단 0과 1로 변경
		if (ret.equals("false"))
			return "0";
		else if (ret.equals("true"))
			return "1";
		else
			return ret;
	}

	void match(int c) {
		if (token == c)
			token = getToken();
		else
			error();
	}

	String expr() { // <expr> -> <bexp>{&<bexp>|'|'<bexp>}|!<expr>
		if (token == '!') { // <expr> -> !<expr>
			match('!');
			compare = true;
			String ope1 = Integer.toString(Integer.parseInt(checkStr(expr())));

			if (ope1.equals("0"))
				return "true";
			else
				return "false";

		} else { // <expr> -> <bexp>
			String ope1 = checkStr(bexp());
			if (token == '&') { // <expr> -> <bexp>{&<bexp>}
				match('&');
				compare = true;
				String ope2 = checkStr(bexp());
				if (ope1.equals(ope2))
					return "true";
				else
					return "false";
			} else if (token == '|') {// <expr> -> <bexp>{|<bexp>}
				match('|');
				compare = true;
				String ope2 = checkStr(bexp());
				if (ope1.equals("0") || ope2.equals("0"))
					return "true";
				else
					return "false";
			}
			return ope1;
		}
	}

	String bexp() { // <bexp> -> <aexp> [<relop><aexp>]
		String ope1 = checkStr(aexp());
		if (token == '\n') { // <bexp> -> <aexp>
			return ope1;
		} else { // 3>=2>=1 해결
			String opr = checkStr(relop()); // <bexp> -> <aexp>[<relop><aexp>]
			int num1 = Integer.parseInt(ope1);

			switch (opr) {
			case "==": {
				compare = true;
				String ope2 = checkStr(expr());
				int num2 = Integer.parseInt(ope2);
				if (num1 == num2)
					return "true";
				else
					return "false";
			}
			case ">": {
				compare = true;
				String ope2 = checkStr(expr());
				int num2 = Integer.parseInt(ope2);
				if (num1 > num2)
					return "true";
				else
					return "false";
			}
			case "<": {
				compare = true;
				String ope2 = checkStr(expr());
				int num2 = Integer.parseInt(ope2);
				if (num1 < num2)
					return "true";
				else
					return "false";
			}
			case ">=": {
				compare = true;
				String ope2 = checkStr(expr());
				int num2 = Integer.parseInt(ope2);
				if (num1 >= num2)
					return "true";
				else
					return "false";
			}
			case "<=": {
				compare = true;
				String ope2 = checkStr(expr());
				int num2 = Integer.parseInt(ope2);
				if (num1 <= num2)
					return "true";
				else
					return "false";
			}
			case "!=": {
				compare = true;
				String ope2 = checkStr(expr());
				int num2 = Integer.parseInt(ope2);
				if (num1 != num2)
					return "true";
				else
					return "false";
			}
			}
			return ope1;
		}

	}

	String relop() {
		String ret = "";
		ret += (char) token;
		switch (token) { // 바로 다음에 올거라 확신이 되는 토큰의 경우 if 로 처리한다.
		case '=': {
			match((char) token);
			if (token == '=') {
				match('=');
				ret += '=';
			}
			return ret;
		}
		case '!': {
			match((char) token);
			if (token == '=') {
				match('=');
				ret += '=';
			}
			return ret;
		}
		case '>': {
			match((char) token);
			if (token == '=') {
				match('=');
				ret += '=';

			}
			return ret;
		}
		case '<': {
			match((char) token);
			if (token == '=') {
				match('=');
				ret += '=';

			}
			return ret;
		}
		default:
			return ret;
		}
	}

	String aexp() {
		/* aexp -> term { '+' term | '-' term } */
		int ret = Integer.parseInt(checkStr(term()));
		while (token == '+') {
			match('+');
			ret += Integer.parseInt(checkStr(term()));
		}
		while (token == '-') {
			match('-');
			ret -= Integer.parseInt(checkStr(term()));
		}
		return checkStr(Integer.toString(ret));
	}

	String term() {
		/* term -> factor { '*' factor | '/' term } */
		int ret = Integer.parseInt(checkStr(factor()));

		while (token == '*') {
			match('*');
			ret *= Integer.parseInt(checkStr(factor()));
		}
		while (token == '/') {
			match('/');
			ret /= Integer.parseInt(checkStr(factor()));
		}
		return Integer.toString(ret);
	}

	String factor() {
		/* factor -> '(' expr ')' | number */

		if (token == '(') {
			match('(');
			String num = checkStr(expr());
			match(')');
			return num;
		} else
			return checkStr(number());
	}

	String number() {
		/* number -> digit{digit} */
		String num = "";
		while (Character.isDigit(token)) {
			num += digit();
			match(token);
		}
		return checkStr(num);
	}

	char digit() {
		/* digit -> 0|1|...|9 */
		if (Character.isDigit(token)) {
			return (char) token;
		} else {
			error();
			return 0;
		}
	}

	int getToken() {

		while (true) {
			try {
				ch = input.read();
				if (ch == ' ' || ch == '\t' || ch == '\r')
					;
				else
					return ch;
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	public void parse() {
		token = getToken(); // get the first character
		command(); // call the parsing command
	}

	public static void main(String[] args) {
		Calculator parser = new Calculator(new PushbackInputStream(System.in));
		while (true) {
			System.out.print(">> ");
			parser.parse();
			parser.compare = false;
		}
	}

}
package rdpparser;

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
public class RDParser {

	int token, ch;
	private PushbackInputStream input;

	public RDParser(PushbackInputStream is) {
		input = is;
	}

	void error() {
		System.out.printf("parse error : %d\n", token);
		System.exit(1);
	}

	boolean command() {
		/* command -> expr '\n' */
		expr();
		if (token == '\n') /* end the parse and print the result */ {
			System.out.println("good syntax");
			return true;
		} else {
			error();
			return false;
		}
	}

	void match(int c) {
		if (token == c)
			token = getToken();
		else
			error();
	}

	void expr() {
		switch (token) {
		case '!': {
			match('!');
			expr();
			break;
		}
		default: {
			bexp();
			if (token == '&') {
				match('&');
				bexp();
				return;
			} else if (token == '|') {
				match('|');
				bexp();
				return;
			}
		}
		}
	}

	void bexp() {
		aexp();
		if (token == '\n')
			return;
		while (token != '\n') { // 3>=2>=1 해결
			relop();
			aexp();
		}
	}

	void relop() {
		switch (token) { // 바로 다음에 올거라 확신이 되는 토큰의 경우 if 로 처리한다.
		case '=': {
			match('=');
			if (token == '=') {
				match('=');
				return;
			}
			break;
		}
		case '!': {
			match('!');
			if (token == '=') {
				match('=');
				return;
			}
			break;
		}
		case '>': {
			match('>');
			if (token == '=') {
				match('=');
				return;
			}
			break;
		}
		case '<': {
			match('<');
			if (token == '=') {
				match('=');
				return;
			}
			break;
		}
		default: {
			match(token);
			return;
		}
		}
	}

	void aexp() { // 오타
		/* aexp -> term { '+' term | '-' term } */
		term();
		if (token == '+') {
			match('+');
			term();
		}
		if (token == '-') {
			match('-');
			term();
		}
	}

	void term() {
		/* term -> factor { '*' factor | '/' term } */
		factor();
		if (token == '*') {
			match('*');
			factor();
		}
		if (token == '/') {
			match('/');
			factor();
		}
	}

	void factor() {
		/* factor -> '(' expr ')' | number */
		if (token == '(') {
			match('(');
			aexp();
			match(')');
		} else {
			number();
		}
	}

	void number() {
		/* number -> digit{digit} */
		digit();
		while (Character.isDigit(token)) {
			digit();
		}
	}

	void digit() {
		/* digit -> 0|1|...|9 */
		if (Character.isDigit(token))
			match(token);
		else
			error();
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

	public boolean parse() {
		token = getToken(); // get the first character
		return command(); // call the parsing command
	}

	public static void main(String[] args) {
		RDParser parser = new RDParser(new PushbackInputStream(System.in));
		while (true) {
			System.out.print(">> ");
			parser.parse();
		}
	}

}
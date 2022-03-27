// Lexer.java
// Lexical analyzer for S

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lexer {
	private char ch = ' ';
	private BufferedReader input;
	private final char eolnCh = '\n';
	private final char eofCh = '\004';
	static boolean interactive = false;

	public Lexer(String fileName) { // source filename
		try {
			input = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
			System.exit(1);
		}
	}

	public Lexer() { // from standard input
		input = new BufferedReader(new InputStreamReader(System.in));
	}

	private char getchar() { // Return next char
		int c = 0;
		try {
			c = input.read();
			if (c == -1)
				c = eofCh;
		} catch (IOException e) {
			System.err.println(e);
		}
		return (char) c;
	}

	public Token getToken() { // Return next token
		do {
			if (Character.isLetter(ch)) { // ident or keyword
				String s = "";
				do {
					s += ch;
					ch = getchar();
				} while (Character.isLetter(ch) || Character.isDigit(ch));
				return Token.idORkeyword(s);
			}

			if (Character.isDigit(ch)) { // number
				String s = "";
				do {
					s += ch;
					ch = getchar();
				} while (Character.isDigit(ch));
				return Token.NUMBER.setValue(s);
			}

			switch (ch) {
			case ' ':
			case '\t':
			case '\r':
				ch = getchar();
				break;

			case eolnCh:
				// ch = getchar();
				if (ch == '\r') // for Windows
					ch = getchar(); // for Windows
				if (ch == eolnCh && interactive)
					return Token.EOF;
				break;

			case '/': // divide
				ch = getchar();
				if (ch != '/')
					return Token.DIVIDE;
				do {
					ch = getchar();
				} while (ch != eolnCh);
				ch = getchar();
				break;

			case '\"': // string literal
				String s = "";
				while ((ch = getchar()) != '\"')
					s += ch;
				ch = getchar();
				return Token.STRLITERAL.setValue(s);
			case eofCh:
				return Token.EOF;
			case '+':
				ch = getchar();
				return Token.PLUS;
			case '-':
				ch = getchar();
				return Token.MINUS;
			case '*':
				ch = getchar();
				return Token.MULTIPLY;
			case '(':
				ch = getchar();
				return Token.LPAREN;
			case ')':
				ch = getchar();
				return Token.RPAREN;
			case '{':
				ch = getchar();
				return Token.LBRACE;
			case '}':
				ch = getchar();
				return Token.RBRACE;
			case '[':
				ch = getchar();
				return Token.LBRACKET;
			case ']':
				ch = getchar();
				return Token.RBRACKET;
			case ';':
				ch = getchar();
				return Token.SEMICOLON;
			case ',':
				ch = getchar();
				return Token.COMMA;
			case '&':
				ch = getchar();
				return Token.AND;
			case '|':
				ch = getchar();
				return Token.OR;
			case '=':
				ch = getchar();
				if (ch != '=')
					return Token.ASSIGN;
				else {
					ch = getchar();
					return Token.EQUAL;
				}
			case '<':
				ch = getchar();
				if (ch != '=')
					return Token.LT;
				else {
					ch = getchar();
					return Token.LTEQ;
				}
			case '>':
				ch = getchar();
				if (ch != '=')
					return Token.GT;
				else {
					ch = getchar();
					return Token.GTEQ;
				}
			case '!':
				ch = getchar();
				if (ch != '=')
					return Token.NOT;
				else {
					ch = getchar();
					return Token.NOTEQ;
				}
			} // switch
		} while (true);
	} // next

	public void error(String msg) {
		System.err.println("Error: " + msg);
		// System.exit(1);
	}

	static public void main(String[] args) {
		Lexer lexer;
		if (args.length == 0)
			lexer = new Lexer();
		else
			lexer = new Lexer(args[0]);

		Token tok = lexer.getToken();
		while (tok != Token.EOF) {
			System.out.println(tok.toString());
			tok = lexer.getToken();
		}
	} // main
}
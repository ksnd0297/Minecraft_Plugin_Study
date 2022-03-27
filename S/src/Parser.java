// Parser.java
// Parser for language S

public class Parser {
	Token token; // current token
	Lexer lexer;
	String funId = "";

	public Parser(Lexer scan) {
		lexer = scan;
		token = lexer.getToken(); // get the first token
	}

	private String match(Token t) {
		String value = token.value();
		if (token == t)
			token = lexer.getToken();
		else
			error(t);
		return value;
	}

	private void error(Token tok) {
		System.err.println("Syntax error: " + tok + " --> " + token);
		token = lexer.getToken();
	}

	private void error(String tok) {
		System.err.println("Syntax error: " + tok + " --> " + token);
		token = lexer.getToken();
	}

	public Command command() {
		// <command> -> <decl> | <function> | <stmt>
		if (isType()) {
			Decl d = decl();
			return d;
		}

		if (token != Token.EOF) {
			Stmt s = stmt();
			return s;
		}
		return null;
	}

	private Decl decl() {
		// <decl> -> <type> id [=<expr>];
		Type t = type();
		String id = match(Token.ID);
		Decl d = null;
		if (token == Token.ASSIGN) {
			match(Token.ASSIGN);
			Expr e = expr();
			d = new Decl(id, t, e);
		} else
			d = new Decl(id, t);

		match(Token.SEMICOLON);
		return d;
	}

	private Decls decls() {
		// <decls> -> {<decl>}
		Decls ds = new Decls();
		while (isType()) {
			Decl d = decl();
			ds.add(d);
		}
		return ds;
	}

	private Type type() {
		// <type> -> int | bool | void | string
		Type t = null;
		switch (token) {
		case INT:
			t = Type.INT;
			break;
		case BOOL:
			t = Type.BOOL;
			break;
		case VOID:
			t = Type.VOID;
			break;
		case STRING:
			t = Type.STRING;
			break;
		default:
			error("int | bool | void | string");
		}
		match(token);
		return t;
	}

	private Stmt stmt() {
		// <stmt> -> <stmts> | <assignment> | <ifStmt> | <whileStmt> | ...
		Stmt s = new Empty();
		switch (token) {
		case SEMICOLON:
			match(token.SEMICOLON);
			return s;
		case LBRACE:
			match(Token.LBRACE);
			s = stmts();
			match(Token.RBRACE);
			return s;
		case IF: // if statement
			s = ifStmt();
			return s;
		case WHILE: // while statement
			s = whileStmt();
			return s;
		case ID: // assignment
			s = assignment();
			return s;
		case LET: // let statement
			s = letStmt();
			return s;
		case READ: // read statement
			s = readStmt();
			return s;
		case PRINT: // print statment
			s = printStmt();
			return s;
		default:
			error("Illegal stmt");
			return null;
		}
	}

	private Stmts stmts() {
		// <stmts> -> {<stmt>}
		Stmts ss = new Stmts();
		while ((token != Token.RBRACE) && (token != Token.END))
			ss.stmts.add(stmt());
		return ss;
	}

	private Let letStmt() {
		// <letStmt> -> let <decls> in <stmts> end
		match(Token.LET);
		Decls ds = decls();
		match(Token.IN);
		Stmts ss = stmts();
		match(Token.END);
		match(Token.SEMICOLON);
		return new Let(ds, null, ss);
	}

	private Read readStmt() { // DongHwan
		// <readStmt> -> read id;
		//
		// parse read statement
		match(Token.READ);
		Identifier id = new Identifier(match(Token.ID));
		//
		return new Read(id);
	}

	private Print printStmt() { // DongHwan
		// <printStmt> -> print <expr>;
		//
		// parse print statement
		match(Token.PRINT);
		Expr e = expr();
		//
		return new Print(e);
	}

	private Stmt assignment() {
		// <assignment> -> id = <expr>;
		Identifier id = new Identifier(match(Token.ID));

		match(Token.ASSIGN);
		Expr e = expr();
		match(Token.SEMICOLON);
		return new Assignment(id, e);
	}

	private If ifStmt() {
		// <ifStmt> -> if (<expr>) then <stmt> [else <stmt>]
		match(Token.IF);
		match(Token.LPAREN);
		Expr e = expr();
		match(Token.RPAREN);
		match(Token.THEN);
		Stmt s1 = stmt();
		Stmt s2 = new Empty();
		if (token == Token.ELSE) {
			match(Token.ELSE);
			s2 = stmt();
		}
		return new If(e, s1, s2);
	}

	private While whileStmt() { // DongHwan
		// <whileStmt> -> while (<expr>) <stmt>
		//
		// parse while statement
		match(Token.WHILE);
		match(Token.LPAREN);
		Expr e = expr();
		match(Token.RPAREN);
		Stmt s = stmt();
		//
		return new While(e, s);
	}

	private Expr expr() {
		// <expr> -> <bexp> {& <bexp> | '|'<bexp>} | !<expr> | true | false
		switch (token) {
		case NOT:
			Operator op = new Operator(match(token));
			Expr e = expr();
			return new Unary(op, e);
		case TRUE:
			match(Token.TRUE);
			return new Value(true);
		case FALSE:
			match(Token.FALSE);
			return new Value(false);
		}

		Expr e = bexp(); // DongHwan
		while (token == Token.AND || token == Token.OR) {
			Operator op = new Operator(match(token));
			Expr b = bexp();
			e = new Binary(op, e, b);
		}
		return e;
	}

	private Expr bexp() {
		// <bexp> -> <aexp> [ (< | <= | > | >= | == | !=) <aexp> ]
		Expr e = aexp();
		//
		// parse relational operations
		if (token == Token.LT || token == Token.LTEQ || token == Token.GT || token == Token.GTEQ || token == Token.EQUAL
				|| token == Token.NOTEQ) { // DongHwan
			Operator op = new Operator(match(token));
			Expr a = aexp();
			e = new Binary(op, e, a);
		}
		//
		return e;
	}

	private Expr aexp() {
		// <aexp> -> <term> { + <term> | - <term> }
		Expr e = term();
		while (token == Token.PLUS || token == Token.MINUS) {
			Operator op = new Operator(match(token));
			Expr t = term();
			e = new Binary(op, e, t);
		}
		return e;
	}

	private Expr term() {
		// <term> -> <factor> { * <factor> | / <factor>}
		Expr t = factor();
		while (token == Token.MULTIPLY || token == Token.DIVIDE) {
			Operator op = new Operator(match(token));
			Expr f = factor();
			t = new Binary(op, t, f);
		}
		return t;
	}

	private Expr factor() {
		// <factor> -> [-](id | <call> | literal | '('<aexp> ')')
		Operator op = null;
		if (token == Token.MINUS)
			op = new Operator(match(Token.MINUS));

		Expr e = null;
		switch (token) {
		case ID:
			Identifier v = new Identifier(match(Token.ID));
			e = v;
			break;
		case NUMBER:
		case STRLITERAL:
			e = literal();
			break;
		case LPAREN:
			match(Token.LPAREN);
			e = aexp();
			match(Token.RPAREN);
			break;
		default:
			error("Identifier | Literal");
		}

		if (op != null)
			return new Unary(op, e);
		else
			return e;
	}

	private Value literal() {
		String s = null;
		switch (token) {
		case NUMBER:
			s = match(Token.NUMBER);
			return new Value(Integer.parseInt(s));
		case STRLITERAL:
			s = match(Token.STRLITERAL);
			return new Value(s);
		}
		throw new IllegalArgumentException("no literal");
	}

	private boolean isType() {
		switch (token) {
		case INT:
		case BOOL:
		case STRING:
			return true;
		default:
			return false;
		}
	}

	public static void main(String args[]) {
		Parser parser;
		Command command = null;
		if (args.length == 0) {
			System.out.print(">> ");
			Lexer.interactive = true;
			// parser = new Parser(new Lexer()); DongHwan
			do {
				parser = new Parser(new Lexer());
				if (parser.token == Token.EOF)
					parser.token = parser.lexer.getToken();
				try {
					command = parser.command();
					if (command != null)
						command.display(0);
					// if (command != null) command.display(0); // display AST
				} catch (Exception e) {
					System.err.println(e);
				}
				System.out.print("\n>> ");
			} while (true);
		} else {
			System.out.println("Begin parsing... " + args[0]);
			parser = new Parser(new Lexer(args[0]));
			do {
				if (parser.token == Token.EOF)
					break;

				try {
					command = parser.command();
					// if (command != null) command.display(0); // display AST
				} catch (Exception e) {
					System.err.println(e);
				}
			} while (command != null);
		}
	} // main
} // Parser
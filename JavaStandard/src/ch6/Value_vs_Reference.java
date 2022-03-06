package ch6;

class Str {
	String str;

	Str(String str) {
		this.str = str;
	}
}

public class Value_vs_Reference {

	public static void addCallByValue(String str) {
		str = str + "456";
	}

	public static void addCallByReference(Str str) {
		str.str = str.str + "456";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc123";
		System.out.println("문자열 값 : " + str);
		addCallByValue(str);
		System.out.println("문자열 값 (Call by Value) : " + str);
		Str temp = new Str(str);
		addCallByReference(temp);
		System.out.println("문자열 값 (Call by Reference) : " + temp.str);
	}
}

package ch6;

class MyMath2 {
	long a, b;

	// 인스턴스변수 a, b만을 이용해서 작업하므로 매개변수가 필요없다.
	long add() {
		return a + b;
	}

	long substract() {
		return a - b;
	}

	long multiply() {
		return a * b;
	}

	double divide() {
		return a / b;
	}

	// 인스턴스변수와 관계없이 매개변수만으로 작업이 가능하다.
	static long add(long a, long b) {
		return a + b;
	}

	static long substract(long a, long b) {
		return a - b;
	}

	static long multiply(long a, long b) {
		return a * b;
	}

	static double divide(long a, long b) {
		return a / b;
	}

}

public class MyMathTest2 {
	public static void main(String[] args) {
		MyMath2 mm = new MyMath2();
		mm.a = 10;
		mm.b = 20;
		System.out.println(MyMath2.add(mm.a, mm.b));
	}

}

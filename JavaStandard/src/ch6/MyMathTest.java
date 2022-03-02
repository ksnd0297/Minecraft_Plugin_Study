package ch6;

class MyMathTest {
	public static void main(String args[]) {
		System.out.println(MyMath.add(10, 20));
		System.out.println(MyMath.minus(20, 10));
	}
}

class MyMath {
	static int add(int a, int b) {
		return a + b;
	}

	static int minus(int a, int b) {
		return a - b;
	}

}
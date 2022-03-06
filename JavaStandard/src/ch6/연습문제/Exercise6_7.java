package ch6.연습문제;

class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double getDistance(int y, int x) {
		return Math.sqrt(Math.pow(Math.abs(this.y - y), 2) + Math.pow(Math.abs(this.x - x), 2));
	}
}

public class Exercise6_7 {
	public static void main(String args[]) {
		MyPoint p = new MyPoint(1, 1);

		System.out.println(p.getDistance(2, 2));
	}
}

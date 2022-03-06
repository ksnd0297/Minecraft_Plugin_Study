package ch6.연습문제;

public class Exercise6_6 {

	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt(Math.pow(Math.abs(y1 - y), 2) + Math.pow(Math.abs(x1 - x), 2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDistance(1, 1, 2, 2));
	}

}

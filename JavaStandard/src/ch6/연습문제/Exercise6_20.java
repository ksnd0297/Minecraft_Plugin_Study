package ch6.연습문제;

public class Exercise6_20 {

	public static int[] shuffle(int[] original) {
		// System.out.println((int) (Math.random() * 10));
		int[] result = new int[9];

		for (int i = 0; i < 9; i++) {
			while (true) {
				int index = (int) (Math.random() * 10 - 1);
				if (result[index] == 0) {
					result[index] = original[i];
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));

		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

}

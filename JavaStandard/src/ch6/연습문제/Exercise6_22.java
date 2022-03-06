package ch6.연습문제;

public class Exercise6_22 {

	static boolean isNumber(String str) {
		boolean flag = false;
		for (int i = 0; !flag && i < str.length(); i++) {
			if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
				flag = true;
		}
		if (flag)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}

}

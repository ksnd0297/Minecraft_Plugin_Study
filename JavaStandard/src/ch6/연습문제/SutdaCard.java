package ch6.연습문제;

public class SutdaCard {
	int num;
	boolean isKwang;

	public SutdaCard() {
		this(1, true);
	}

	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String info() {
		if (isKwang) {
			return num + "K";
		} else
			return num + "";
	}
}

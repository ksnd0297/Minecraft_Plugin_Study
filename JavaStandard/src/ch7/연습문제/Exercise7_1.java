package ch7.연습문제;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		int index = 0;
		for (int i = 1; i <= cards.length / 2; i++) {
			boolean isKwang = false;
			if (i == 1 || i == 3 || i == 8)
				isKwang = true;
			SutdaCard card = new SutdaCard(i, isKwang);
			cards[index] = card;
			index++;
		}
		for (int i = 1; i <= cards.length / 2; i++) {
			SutdaCard card = new SutdaCard(i, false);
			cards[index] = card;
			index++;
		}
	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Exercise7_1 {
	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();

		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ", ");
		}
	}
}

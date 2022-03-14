//package ch7;
//
//import java.util.Vector;
//
//class Buyer {
//	int money = 1000;
//	int bonusPoint = 0;
//	Vector item = new Vector();
//
//	void buy(Product p) {
//		if (money < p.price) {
//			System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
//			return;
//		}
//
//		money -= p.price;
//		bonusPoint += p.bonusPoint;
//		item.add(p);
//		System.out.println(p + "을/를 구입하셨습니다.");
//	}
//
//	void refund(Product p) {
//		if (item.remove(p)) {
//			money += p.price;
//			bonusPoint -= p.bonusPoint;
//			System.out.println(p + "을/를 반품하였습니다.");
//		} else {
//			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
//		}
//	}
//
//	void summary() {
//		int sum = 0;
//		String itemList = "";
//
//		if (item.isEmpty()) {
//			System.out.println("구입하신 제품이 없습니다.");
//			return;
//		}
//
//		for (int i = 0; i < item.size(); i++) {
//			Product p = (Product) item.get(i);
//			sum += p.price;
//			itemList += (i == 0) ? "" + p : ", " + p;
//		}
//		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
//		System.out.println("구입하신 제품은" + itemList + "입니다.");
//	}
//}
//
//public class PolyArgumentTest3 {
//	public static void main(String args[]) {
//		Buyer b = new Buyer();
//		Tv tv = new Tv();
//		Computer com = new Computer();
//		Audio audio = new Audio();
//
//		b.buy(tv);
//		b.buy(com);
//		b.buy(audio);
//		b.summary();
//		System.out.println();
//		b.refund(com);
//		b.summary();
//	}
//}

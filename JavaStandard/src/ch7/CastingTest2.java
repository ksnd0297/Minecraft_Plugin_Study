//package ch7;
//
//public class CastingTest2 {
//	public static void main(String args[]) {
//		Car car = new Car();
//		Car car2 = new FireEngine(); // 문제 없음
//		FireEngine fe = null;
//
//		car2.drive();
//		car2.stop();
//
//		fe = (FireEngine) car2;
//		fe.drive();
//		fe.water();
//
//		car = fe;
//		car.drive();
//		car.stop();
//	}
//}
//
//class Car {
//	String color;
//	int door;
//
//	void drive() {
//		System.out.println("drive, Brrrrr~");
//	}
//
//	void stop() {
//		System.out.println("stop!!!!");
//	}
//}
//
//class FireEngine extends Car {
//	void drive() {
//		System.out.println("FireEngine drive, Brrrrr~");
//	}
//
//	void water() {
//		System.out.println("water!!!");
//	}
//}
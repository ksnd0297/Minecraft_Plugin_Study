//package ch7;
//
//public class CastingTest1 {
//	public static void main(String args[]) {
//		Car car = new Car();
//		FireEngine fe = new FireEngine();
//		FireEngine fe2 = null;
//
//		car.drive();
//		car.drive();
//		car.stop();
//		// car.water();
//		fe = (FireEngine) car;
//		fe2 = (FireEngine) car;
//		fe2.water();
//		fe2.drive();
//		fe2.stop();
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

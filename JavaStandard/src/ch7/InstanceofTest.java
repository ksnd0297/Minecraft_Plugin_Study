//package ch7;
//
//public class InstanceofTest {
//	public static void main(String args[]) {
//		FireEngine fe = new FireEngine();
//		Car car = new Car();
//
//		System.out.println("Error Here !");
//		FireEngine fe2 = (FireEngine) car;
//
//		if (fe instanceof FireEngine) {
//			System.out.println("This is a FireEngine instance.");
//		}
//
//		if (fe instanceof Car) {
//			System.out.println("This is a Car instance.");
//		}
//
//		if (fe instanceof Object) {
//			System.out.println("This is a Object instance.");
//		}
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
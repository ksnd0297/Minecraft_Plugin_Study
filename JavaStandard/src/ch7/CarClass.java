//package ch7;
//
//class Car {
//	private static Car car = new Car();
//
//	private Car() {
//	}
//
//	public static Car getInstance() {
//		return car;
//	}
//
//	private static boolean isUse = false;
//
//	public static void drive() {
//		isUse = true;
//		System.out.println("start driving");
//	}
//
//	public static void parking() {
//		isUse = false;
//		System.out.println("parking");
//	}
//
//	public static boolean isEnableUseCar() {
//		return !isUse;
//	}
//
//	public static void getIsUse() {
//		System.out.println("isUse : " + isUse);
//	}
//}
//
//public class CarClass {
//	public static void main(String args[]) {
//		Car car = Car.getInstance();
//		Car.drive();
//		Car.getIsUse();
//		Car car2 = Car.getInstance();
//		car2.getIsUse();
//
//	}
//}

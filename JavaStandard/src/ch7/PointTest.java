//package ch7;
//
//public class PointTest {
//	public static void main(String[] args) {
//		Point3D p3 = new Point3D(1, 2, 3);
//		Point3D p2 = new Point3D();
//		System.out.println(p2.getLocation());
//	}
//}
//
//class Point {
//	int x;
//	int y;
//
//	Point() {
//		this(10, 20);
//	}
//
//	Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//
//	String getLocation() {
//		return "x : " + x + ", y : " + y;
//	}
//}
//
//class Point3D extends Point {
//	int z;
//
//	Point3D() {
//		super(100, 200);
//		this.z = 300;
//	}
//
//	Point3D(int x, int y, int z) {
//		super(x, y);
//		this.z = z;
//	}
//
//	String getLocation() {
//		return "x : " + x + ", y : " + y + ", z : " + z;
//	}
//}
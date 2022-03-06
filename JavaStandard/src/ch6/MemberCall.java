package ch6;

public class MemberCall {
	int iv = 10;
	static int cv = 20;

	int iv2 = cv;
	// static int cv2 = iv;
	static int cv2 = new MemberCall().iv;

	static void staticMethod1() {
		System.out.println(cv);
		// System.out.println(iv);
		MemberCall c = new MemberCall();
		System.out.println(c.iv);
	}

	void instanceMethod1() {
		System.out.println(cv); // 인스턴스 메소드 내에서는 인스턴스 변수 호출 가능
		System.out.println(iv);
	}

	static void staticMethod2() {
		staticMethod1();
		// instanceMethod1();
		MemberCall c = new MemberCall();
		c.instanceMethod1();
	}

	void instanceMetho2() {
		staticMethod1();
		instanceMethod1();
	}
}

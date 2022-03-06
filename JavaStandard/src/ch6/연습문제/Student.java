package ch6.연습문제;

public class Student {
	String name;
	int ban, no, kor, eng, math;

	public Student() {
	}

	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void info() {
		System.out.println("생성자 실행");
		System.out.println(this.name);
		System.out.println(this.getTotal());
		System.out.println(this.getAverage());
	}

	public int getTotal() {
		return kor + eng + math;
	}

	public float getAverage() {
		return (kor + eng + math) / 3;
	}
}

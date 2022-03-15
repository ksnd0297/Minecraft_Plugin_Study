//package ch7;
//
//class Tv {
//	protected boolean power;
//	protected int channel;
//	protected int volume;
//
//	public void power() {
//		power = !power;
//	}
//
//	public void channelUp() {
//		channel++;
//	}
//
//	public void channelDown() {
//		channel--;
//	}
//
//	public void volumeUp() {
//		volume++;
//	}
//
//	public void volumeDown() {
//		volume--;
//	}
//}
//
//class VCR {
//	protected int counter;
//
//	public void play() {
//		System.out.println("플레이");
//	}
//
//	public void stop() {
//		System.out.println("정지");
//	}
//
//	public void reset() {
//		System.out.println("리셋");
//		counter = 0;
//	}
//
//	public int getCounter() {
//		System.out.println("카운터 반환");
//		return counter;
//	}
//
//	public void setCounter(int c) {
//		System.out.println("카운터 설정");
//		counter = c;
//	}
//}
//
//interface IVCR {
//	public void play();
//
//	public void stop();
//
//	public void reset();
//
//	public int getCounter();
//
//	public void setCounter(int c);
//}
//
//class TVCR extends Tv implements IVCR {
//	VCR vcr = new VCR();
//
//
//
//	public void stop() {
//		vcr.stop();
//	}
//
//	public void reset() {
//		vcr.reset();
//	}
//
//	public int getCounter() {
//		return vcr.getCounter();
//	}
//
//	public void setCounter(int c) {
//	}
//}
//
//public class Interface {
//	public static void main(String args[]) {
//		TVCR tvcr = new TVCR();
//		tvcr.play();
//		tvcr.stop();
//		tvcr.reset();
//
//	}
//}

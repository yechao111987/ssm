package yechao;

public class TestThread extends Thread {

	public void run() {
		while (true) {
			System.out.println("AAAA");
		}
	}

	public static void main(String[] argStrings) {
		TestThread aa = new TestThread();
		aa.run();
		while (true) {
			System.out.println("BBBBBB");
		}
	}

}

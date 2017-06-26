package yechao;

public class Demo implements Runnable{
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestThread aaTestThread=new TestThread();
		Demo demo=new Demo();		
		Thread aa=new Thread(demo);
		aa.start();
		aaTestThread.start();
		while (true) {
			System.out.println(aaTestThread.getStackTrace());
			System.out.println("bbbbbbb");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("function 2");
		
	}

}

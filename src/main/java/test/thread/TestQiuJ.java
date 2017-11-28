package test.thread;

public class TestQiuJ {
	/**
	 * 3x+y+1/3*z=100
	 * x+y+z=100
	 * @param args
	 */

	public static void main(String[] args) {
		for (int x = 1; x <= 33; x++) {
			for (int y = 1; y <= 97; y++) {
				for (int z = 1; z < 99; z++) {
					if (z%3==0) {
						if (x+y+z==100 && 3*x+y+1/3 * z==100) {
							System.out.println("x="+x+","+",y="+y+",z="+z);
						}
					}
				}
			}
		}

	}

}

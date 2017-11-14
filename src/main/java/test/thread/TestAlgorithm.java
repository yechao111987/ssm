package test.thread;

public class TestAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//欧几里得算法算法
		OuJiLiDe(4, 12);
		

	}

	/**
	 * 欧几里得算法:求两个正整数之间最大的公约数
	 * 原理：辗转相除法，小的数处于余数，返回余数。
	 */
	public static void OuJiLiDe(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (a % b != 0) {
			int yushu = a % b;
			a=b;
			b = yushu;

		}
		System.out.println(b);

	}
	/**
	 * 冒泡排序算法
	 * 
	 */
	public static void Sort_MaoPao(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i]>a[j]) {
					
				}
			}
		}
	}

}

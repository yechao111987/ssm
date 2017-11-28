package test.demo;

public class TestString {
	private String username;

	public TestString(String username) {
		this.username = username;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("yechao");
		String str2 = new String("yechao");
		if (str1 == str2) {
			System.out.println("str1==str2");
		} else {
			System.out.println("str1!=str2");

		}
		// 这个相等是因为String字符串中重写了这个方法
		if (str1.equals(str2)) {
			System.out.println("str1.equals(str2)");

		} else {
			System.out.println("str1.equals(str2)不相等");

		}
		if (str1.equalsIgnoreCase("yechao")) {
			System.out.println("str1.equalsIgnoreCase(\"yechao\")");

		}

		if (str1.equalsIgnoreCase(str2)) {
			System.out.println("str1.equalsIgnoreCase(str2)");

		}

		// 测试类的方法
		TestString ts1 = new TestString("yechao");
		TestString ts2 = new TestString("yechao");
		if (ts1 == ts2) {
			System.out.println("ts1 == ts2");
		} else {
			System.out.println("ts1 != ts2");

		}
		// 这个很有趣，不相等
		if (ts1.equals(ts2)) {
			System.out.println("ts1.equals(ts2)");

		} else {
			System.out.println("str1.equals(str2)不相等");

		}

	}

}

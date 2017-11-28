package test.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import javax.print.attribute.HashAttributeSet;

public class TestListAndArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// array
		String[] str = new String[5];
		str[0] = "1";
		str[1] = "2";
		for (int i = 0; i < str.length; i++) {
			System.out.println("str1=" + str[i] + ',');
		}
		String[] str1 = { "4", "5" };
		for (int i = 0; i < str1.length; i++) {
			System.out.println("str1=" + str1[i] + ',');
		}
		// List，通常开发中直接定义数据类型为list接口，实际过程中用不同的list来实现
		List<String> list = new ArrayList<String>();
		list.add("list1");
		list.add(1, "list2");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("list=" + string + ",");
		}
		// linkedList，双向链表，提供了头部，手部插入和删除的方法，插入，删除简单，查找复杂
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("linkedList1");
		linkedList.addFirst("linkedList0");
		for (Iterator iterator = linkedList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("linkedList=" + string + ",");
		}
		// arraylist,可变数组，插入，删除复杂，查找简单
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("arraylist1");
		arrayList.add("arraylist2");
		arrayList.remove(0);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println("arraylist=" + arrayList.get(i));
		}
		// vector 同步的arraylist
		Vector<String> vector = new Vector<String>();
		vector.add("1");
		vector.add("1");
		// Stack
		Stack<String> stack = new Stack<String>();
		stack.add("stack1");
		stack.add("stack2");
		stack.push("stack-push");
		System.out.println("stack of peek:" + stack.peek());
		System.out.println("stakc of pop:" + stack.pop());
		System.out.println("stakc of pop:" + stack.pop());
		System.out.println("stakc of search:" + stack.search("stack2"));
		for (Iterator iterator = stack.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("stack=" + string + ",");
		}
		// set
		Set<String> set = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		set.add("set1");
		set.add("set2");
		set.add("set3");
		set2.add("set1");
		set2.add("set2");
		set2.add("set3");
		set2.add("set3");
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("set=" + string);

		}
		for (Iterator iterator = set2.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("set2=" + string);

		}
		// map
		Map<String, Object> map = new HashMap<String, Object>();

		// hanshmap，非同步的
		// hashmap和hashtable的区别，http://www.importnew.com/7010.html，线程安全和非线程安全，速度，jdk1.5，ConCurrentHashMap
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("hashmap1", "hashmap1");
		// hashtable,同步的
		Hashtable<String, Object> hashtable = new Hashtable<String, Object>();
		hashtable.put("hanshtable1", "table1");
		// HashMap是hash table的一个实现，它中的键值是无序的。
		// TreeMap是基于红黑树结构的一个实现，它是根据key来排序的。
		// LinkedHashMap保留了插入的顺序。
		// HashTabe是同步的，与HashMap相比，它有个同步的开销，因此如果程序是线程安全的，那么HashMap是个不错的选择。
		// ConcurrentHashMap，个更快的hashmap，它提供了好得多的并发性。多个读操作几乎总可以并发地执行。他是锁段（默认：把hash表分为16个
		// 段），在get，put，remove等操作中，ConcurrentHashMap只锁定当前需要用到的段，只有在求size的时候才锁定整张hash表
	}

}

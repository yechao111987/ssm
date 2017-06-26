package yechao;

public class StrBuffer {
	
	
	
	
	public static void main(String[] args){
		
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("abc");
		System.out.println(stringBuffer);
		stringBuffer.append(111);
		System.out.println(stringBuffer);
		stringBuffer.delete(2, 4);
		System.out.println(stringBuffer);
		System.out.println("aa");
		
		int[] aa;
		aa=new int[3];
		aa[0]=0;
		aa[1]=1;
		aa[2]=2;
		int length=aa.length;
		
		String[][] strings=new String[][]{{"1","2"},{"2","3"}};
		System.out.println(strings.toString());
		
	}

}

package test.demo;

import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;


public class TestPrintCurrentTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println(date.toString());
		
		long ct=System.currentTimeMillis();
		System.out.println(ct);
		

	}

}

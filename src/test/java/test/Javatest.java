package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Javatest {

	public static void main(String[] args) 
	{
		String timestamp = new SimpleDateFormat("YYYY_MM_dd-HH.mm.ss").format(new Date());
		System.out.println(timestamp);

	}

}

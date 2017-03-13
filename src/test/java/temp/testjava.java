package temp;

import library.ObjFactory;

public class testjava
{


	
	public static void main(String[] args)
	{
		String sheetname ="Sample";	

		String data = ObjFactory.getexcel().getCelData("BusinessDetailsPg", 1, 3);
		
		System.out.println(data);
		
		ObjFactory.getexcel().setCelData(sheetname, 0, 0, data);
	
		System.out.println("Excel updated successfully");

	}

}

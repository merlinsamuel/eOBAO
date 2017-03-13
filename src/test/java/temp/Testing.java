package temp;

import org.testng.annotations.Test;

import library.ObjFactory;

public class Testing 
{
	
	@Test
	public void excelPrint()
	{
		ObjFactory.getexcel().setCelData("Sample", 0, 0, "SoleTrader");
	}

}

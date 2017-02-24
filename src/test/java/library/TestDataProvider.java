package library;

import org.testng.annotations.DataProvider;

public class TestDataProvider
{
	@DataProvider(name = "IntroPg")
	public static Object[][] dpforIntroPg()
	{
		return ObjFactory.getexcel().ReadExceldata("TC001", "Intro_0");
	}
	
	@DataProvider(name = "BusinessDetailsPg")
	public static Object[][] dpforBusinessDetailsPg()
	{
		return ObjFactory.getexcel().ReadExceldata("TC001", "SoleTraderDP");
	}
}

package dataprovider;

import org.testng.annotations.DataProvider;

import Factory.DataProviderFactory;

public class ApplicationData
{

	@DataProvider(name = "IntroPg")
	public static Object[][] dpforIntroPg()
	{
		return DataProviderFactory.getexcel().ReadExceldata("Intro_0");
	}
	
	@DataProvider(name = "BusinessDetailsPg")
	public static Object[][] dpforBusinessDetailsPg()
	{
		return DataProviderFactory.getexcel().ReadExceldata("BD_1");
	}

}

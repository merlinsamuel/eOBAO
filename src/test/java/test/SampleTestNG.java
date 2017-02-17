package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Factory.DataProviderFactory;

public class SampleTestNG
{
	Object[][] data;
	Object[][] testdata;
	int Colcount;
	int Rowcount;
		
	
	public Object[][] readallData(String testcaseid, String sheetname)
	{
		Rowcount = DataProviderFactory.getexcel().getRowCount(sheetname);
		Colcount = DataProviderFactory.getexcel().getColCount(sheetname);
		
		//System.out.println("Row Count: "+Rowcount);
		//System.out.println("Col count: "+Colcount);
		
		data=new Object[Rowcount][Colcount];
				
		//Get all test data from excel tab
		for(int i=0; i<Rowcount; i++)
		{
			for(int j=0; j<Colcount; j++)
			{
			data[i][j] = DataProviderFactory.getexcel().getCelData(sheetname, i, j);
			}
		}
		
		//---------------------------------------------------------------------------------
		
		//Find a matching row and retrieve the data of that particular row
		testdata = new Object[1][Colcount-1];
		for (int index=1; index<Rowcount; index++)
		{
			if (data[index][0].equals(testcaseid))
			{
				for(int i=0; i<1; i++)
				{
					for(int j=0; j<Colcount-1; j++)
					{
						testdata[i][j]= DataProviderFactory.getexcel().getCelData(sheetname, index, j+1);
						//System.out.println("Test Data for TC001: "+testdata[i][j]);
					}
				}
			}
		}
		//System.out.println("Array length: "+testdata[0].length);  
		return testdata;
	}
	
	@Test(dataProvider = "TC001")
	public void TC001(String txt1, String txt2)
	{
		System.out.println(txt1);
		System.out.println(txt2);
	}
	
	@DataProvider(name = "TC001")
	public Object[][] dataforTC001()
	{
		return readallData("TC001","sample");
	}
}
		

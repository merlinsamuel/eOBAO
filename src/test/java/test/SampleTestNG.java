package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Factory.DataProviderFactory;

public class SampleTestNG
{
	Object[][] data;
	int Colcount;
	
	@Test(priority = 1)
	public void readallData()
	{
		int Rowcount = DataProviderFactory.getexcel().getRowCount("sample");
		Colcount = DataProviderFactory.getexcel().getColCount("sample");
		
		data=new Object[Rowcount][Colcount];
				
		//Get all data from excel tab including testcase id
		for(int i=0; i<Rowcount; i++)
		{
			for(int j=0; j<Colcount; j++)
			{
			data[i][j] = DataProviderFactory.getexcel().getExcelCelData("sample", i, j);
			}
		}
	}
	
	
	@Parameters({"testcaseid", "testrun"})
	@Test(priority = 2)
	public void testdataforsinglerun(String testid, int index)
	{
			
		if (data[index][0].equals(testid))
		{
			for(int j=1; j<Colcount; j++)
			{
				System.out.println("Data of "+testid+" are: "+data[index][j]);
			}
			
		}
	}
	
}
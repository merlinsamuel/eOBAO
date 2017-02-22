package temp;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import library.ObjFactory;

public class SampleTestNG
{
	Object[][] data;
	Object[] testdata;
	int Colcount;
	int Rowcount;
		
	@Parameters({"testcaseid"})
	public Object[] readallData(String testcaseid, String sheetname)
	{
		Rowcount = ObjFactory.getexcel().getRowCount(sheetname);
		Colcount = ObjFactory.getexcel().getColCount(sheetname);
		
		//System.out.println("Row Count: "+Rowcount);
		//System.out.println("Col count: "+Colcount);
		
		data=new Object[Rowcount][Colcount];
				
		//Get all test data from excel tab
		for(int i=0; i<Rowcount; i++)
		{
			for(int j=0; j<Colcount; j++)
			{
			data[i][j] = ObjFactory.getexcel().getCelData(sheetname, i, j);
			}
		}
		
		//---------------------------------------------------------------------------------
		
		//Find a matching row and retrieve the data of that particular row
		testdata = new Object[Colcount-1];
		for (int index=1; index<Rowcount; index++)
		{
			if (data[index][0].equals(testcaseid))
			{
				for(int i=0; i<1; i++)
				{
					for(int j=0; j<Colcount-1; j++)
					{
						testdata[j]= ObjFactory.getexcel().getCelData(sheetname, index, j+1);
						//System.out.println("Test Data for TC001: "+testdata[j]);
					}
				}
			}
		}
		//System.out.println("Array length: "+testdata[0].length);  
		return testdata;
	}
	
	//@Parameters({"testcaseid"})
	@Test
	public void PrintA(String testcaseid)
	{
		SampleTestNG obj = new SampleTestNG();
		
		Object[] data = obj.readallData(testcaseid, "sample");
		System.out.println("No of elements in Array: "+data.length);
		
		for(int i=0; i<data.length; i++)
		{
			System.out.println(data[i]);
		}
	}
}
		

package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import factory.DataProviderFactory;

public class ExcelDataProvider
{
	XSSFWorkbook wb;
	
	
	public ExcelDataProvider()
	{
		File src = new File(DataProviderFactory.getconfig().getTestDataPath());
		
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} 
		catch (IOException e) 
		{
			System.out.println("Exception message is: "+e.getMessage());
		}
	}
	
	public int getRowCount(String sheetname)
	{
		int row = wb.getSheet(sheetname).getPhysicalNumberOfRows();
		return row;
	}
	
	public int getColCount(String sheetname)
	{
		int col = wb.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();
		return col;
	}
	
	public String getCelData(String sheetname, int row, int col)
	{
		String data = wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public Object[][] ReadExceldata(String testcaseid, String sheetname)
	{
		int row = DataProviderFactory.getexcel().getRowCount(sheetname);
		int col = DataProviderFactory.getexcel().getColCount(sheetname);
		
		Object[][] data = new Object[row][col];
				
		//Get all test data from excel tab
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<col; j++)
			{
				data[i][j] = DataProviderFactory.getexcel().getCelData(sheetname, i, j);
			}
		}
		
		
		//Match the Testcase id from XML with array collection and return the test data pertaining to particular testcaseid
		Object[][] testdata = new Object[1][col-1];
		
		for (int index=1; index<row; index++)
		{
			if (data[index][0].equals(testcaseid))
			{
				for(int i=0; i<1; i++)
				{
					for(int j=0; j<col-1; j++)
					{
						testdata[i][j]= DataProviderFactory.getexcel().getCelData(sheetname, index, j+1);
					}
				}
			}
		}
		return testdata;
	}
}
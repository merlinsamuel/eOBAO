package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestData
{
	XSSFWorkbook wb;
	
	
	public ExcelTestData()
	{
		File src = new File(ObjFactory.getconfig().getTestDataPath());
		
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
		Cell cellvalue = wb.getSheet(sheetname).getRow(row).getCell(col);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(cellvalue);
		return data;
	}
	
	public Object[][] ReadExceldata(String testcaseid, String sheetname)
	{
		int row = ObjFactory.getexcel().getRowCount(sheetname);
		int col = ObjFactory.getexcel().getColCount(sheetname);
		
		Object[] tc_id = new Object[row];
				
		//Get all test data from excel tab
		for(int i=1; i<row; i++)
		{
			tc_id[i] = wb.getSheet(sheetname).getRow(i).getCell(0).getStringCellValue();
		}
		
		
		//Match the Testcase id from XML with array collection and return the test data pertaining to particular testcaseid
		Object[][] testdata = new Object[1][col-1];
		
		for (int index=1; index<row; index++)
		{
			if (tc_id[index].equals(testcaseid))
			{
				for(int i=0; i<1; i++)
				{
					for(int j=0; j<col-1; j++)
					{
						testdata[i][j]= ObjFactory.getexcel().getCelData(sheetname, index, j+1);
					}
				}
			}
		}
		return testdata;
	}
}
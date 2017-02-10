package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Factory.DataProviderFactory;

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
	
	public String getExcelCelData(String sheetname, int row, int col)
	{
		String data = wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public Object[][] ReadExceldata(String sheetname)
	{
		int row = DataProviderFactory.getexcel().getRowCount(sheetname);
		int col = DataProviderFactory.getexcel().getColCount(sheetname);
		
		Object[][] data = new Object[row-1][col];
		
		for(int i=1; i<row; i++)
		{
			for(int j=0; j<col; j++)
			{
				data[i-1][j] = DataProviderFactory.getexcel().getExcelCelData(sheetname, i, j);
				//System.out.println(data[i][j]);
			}
		}
		return data;
	}

}

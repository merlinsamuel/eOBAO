package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src = new File("C:\\Merlin_Neon\\com.eobao\\ExcelData\\ST_datasheet.xlsx");
		
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
	
	public String getExcelData(int sheetnum, int row, int col)
	{
		String data = wb.getSheetAt(sheetnum).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public String getExcelData(String sheetname, int row, int col)
	{
		String data = wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}

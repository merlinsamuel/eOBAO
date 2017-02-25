package temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import library.ObjFactory;

public class Javatest
{
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public static void main(String[] args) 
	{
		//String timestamp = new SimpleDateFormat("YYYY_MM_dd-HH.mm.ss").format(new Date());
		//System.out.println(timestamp);
		
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
		
		DataFormatter ObjDefaultFormatter = new DataFormatter();
        sheet = wb.getSheet("sample");  
        Cell cellvalue = sheet.getRow(1).getCell(2);
        System.out.println(cellvalue);
        String data = ObjDefaultFormatter.formatCellValue(cellvalue);
        System.out.println(data);
        
		int row = ObjFactory.getexcel().getRowCount("SoleTraderDP");
				
		Object[][] dataarr = new Object[row][1];
				
		//Get all test data from excel tab
		for(int i=1; i<row; i++)
		{
			for(int j=0; j<1; j++)
			{
				dataarr[i][j] = ObjFactory.getexcel().getCelData("SoleTraderDP", i, j);
				System.out.println(dataarr[i][j]);
			}

		}
       
	}
}

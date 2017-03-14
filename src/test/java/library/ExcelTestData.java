package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestData
{
	XSSFWorkbook wb;
	File src;
	
	
	public ExcelTestData()
	{
		src = new File(ObjFactory.getconfig().getTestDataPath());
		
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
	
	public CellStyle setCelStyle(String status)
	{
		XSSFCellStyle style = wb.createCellStyle();
		
		//Set cell border type
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		
		//set text wrap style
		style.setWrapText(true);
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		
		//Set cell border color
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		
		//set cell Font
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.BLACK.getIndex());
		font.setBold(true);
		style.setFont(font);
		
		//set Foreground color and fill pattern
		if(status.equalsIgnoreCase("Complete")||status.equalsIgnoreCase("Pass"))
		{
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		else if(status.equalsIgnoreCase("InComplete")||status.equalsIgnoreCase("Fail"))
		{
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		
		return style;
	}
	
	public void setCelData(String sheetname, int row, int col, String status)
	{
		try
		{
			Cell cellvalue = wb.getSheet(sheetname).getRow(row).createCell(col);
			cellvalue.setCellValue(status);
			cellvalue.setCellStyle(setCelStyle(status));
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
		} 
		catch (IOException e)
		{
			System.out.println("Exception occured while Excel update"+e);
		}
	}
	
	
	public void setCelData(String sheetname, int row, int col, int status)
	{
		try
		{
			Cell cellvalue = wb.getSheet(sheetname).getRow(row).createCell(col);
			cellvalue.setCellValue(status);
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
		} 
		catch (IOException e)
		{
			System.out.println("Exception occured while Excel update"+e);
		}
	}
	
	
	//Return testdata from Excel for DataProvider
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
	

	public int getIndex(String testcaseid, String sheetname)
	{
		int index=0;
		
		int row = ObjFactory.getexcel().getRowCount(sheetname);
		Object [][] data = new Object[row][1];
		
		for(int i=0; i<row; i++)
		{
			data[i][0]=ObjFactory.getexcel().getCelData(sheetname, i, 0);
			if(data[i][0].equals(testcaseid))
			{
				index = i;
				break;
			}
		}
	return index;
	}
	
	
	public int getEmptyRowIndex(String sheetname)
	{
		int index=0;
		
		int row = ObjFactory.getexcel().getRowCount(sheetname);
		Object [] data = new Object[row];
		
		for(int i=0; i<row; i++)
		{
			data[i]=ObjFactory.getexcel().getCelData(sheetname, i, 1);
			if(data[i].equals(""))
			{
				index = i;
				break;
			}
		}
		return index;
	}

}
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestData
{
	XSSFWorkbook wb;
	File src;
	XSSFRow ROW;
	
	
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
	
	public int getPhysicalRowCount(String sheetname)
	{
		int row = wb.getSheet(sheetname).getPhysicalNumberOfRows();
		return row;
	}
	
	public int getLastRowIndex(String sheetname)
	{
		int row = wb.getSheet(sheetname).getLastRowNum();
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
	
	
	//Cell Style for String type data
	public CellStyle setCelStyle(String text)
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
		font.setBold(false);
		style.setFont(font);
		
		//set Foreground color and fill pattern
		if(text.equalsIgnoreCase("Complete")||text.equalsIgnoreCase("Pass"))
		{
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		else if(text.equalsIgnoreCase("InComplete")||text.equalsIgnoreCase("Fail"))
		{
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		
		return style;
	}
	
		
	//Cell Style for Numeric type data
	public CellStyle setCelStyle()
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
		font.setBold(false);
		style.setFont(font);
		
		return style;
	}
	
	
	//String type data update
	public void setCelData(String sheetname, int row, int col, String text)
	{
		ROW = wb.getSheet(sheetname).getRow(row);
		
		if(ROW == null)
		{
			ROW = wb.getSheet(sheetname).createRow(row);
		}
		
		Cell cellvalue = ROW.createCell(col);
		cellvalue.setCellValue(text);
		cellvalue.setCellStyle(setCelStyle(text));
		try
		{
			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
		} 
		catch (IOException e)
		{
			System.out.println("Exception occured while Excel update"+e);
		}
	}
	
	
	//Numeric type data update
	public void setCelData(String sheetname, int row, int col, int number)
	{
		ROW = wb.getSheet(sheetname).getRow(row);
		
		if(ROW == null)
		{
			ROW = wb.getSheet(sheetname).createRow(row);
		}
		
		Cell cellvalue = ROW.createCell(col);
		cellvalue.setCellValue(number);
		cellvalue.setCellStyle(setCelStyle());
		
		try
		{
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
		int row = ObjFactory.getexcel().getPhysicalRowCount(sheetname);
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
		
		int row = getPhysicalRowCount(sheetname);
		Object [][] data = new Object[row][1];
		
		for(int i=0; i<row; i++)
		{
			data[i][0]=getCelData(sheetname, i, 0);
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
		int index=getLastRowIndex(sheetname)+1;
		return index;
	}

}
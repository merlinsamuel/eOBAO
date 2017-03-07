package temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import library.ObjFactory;

public class Javatest
{
	
	public static void main(String[] args) throws Exception 
	{
		
		XSSFWorkbook wb = null;
		
		File src = new File(ObjFactory.getconfig().getTestDataPath());
		
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		
		String status = "Fail";
		
		XSSFCellStyle style = wb.createCellStyle();
		if(status.equalsIgnoreCase("Pass"))
		{
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		}
		else
		{
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
		}
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.BLACK.getIndex());
		style.setFont(font);
		
		
		wb.getSheet("FBLogin").getRow(1).createCell(3).setCellValue("Pass");
		
		wb.getSheet("FBLogin").getRow(1).getCell(3).setCellStyle(style);
		
		wb.getSheet("FBLogin").getRow(1).createCell(4).setCellValue(ObjFactory.getutil().getCurrentTimestamp());
		
		
		System.out.println("Excel Updated");
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
		
	}
}

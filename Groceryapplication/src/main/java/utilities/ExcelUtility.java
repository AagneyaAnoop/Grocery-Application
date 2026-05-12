package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	
	static FileInputStream F;
	static XSSFWorkbook W;
	static XSSFSheet S;
	
	public static String getStringData(int a, int b, String sheet) throws IOException
	{
		F=new FileInputStream(Constant.TESTDATA);
		W=new XSSFWorkbook(F);
		S=W.getSheet(sheet);
		XSSFRow r=S.getRow(a);
		XSSFCell c=r.getCell(b);
		return c.getStringCellValue();
	}
	
	public static int getIntegerData(int a, int b, String sheet) throws IOException
	{
		F=new FileInputStream(Constant.TESTDATA);
		W=new XSSFWorkbook(F);
		S=W.getSheet(sheet);
		XSSFRow r=S.getRow(a);
		XSSFCell c=r.getCell(b);
		int y=(int) c.getNumericCellValue();
		return y;
	}

}

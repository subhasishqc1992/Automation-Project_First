package com.sauceDemoEcommerce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow wr;
	public static XSSFCell cell;
	public static FileOutputStream fo;
	
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException {
		
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;		
	}
	
public static int getCellCount(String xlFile, String xlSheet, int rownum) throws IOException {
		
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		wr = ws.getRow(rownum);
		int cellCount = wr.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;		
	}

public static String getCellValue(String xlFile, String xlSheet, int rownum, int cellnum) throws IOException {
	fi = new FileInputStream(xlFile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlSheet);
	wr = ws.getRow(rownum);
	cell = wr.getCell(cellnum);
	String data;
	
	try {
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		return cellData;
	} catch (Exception e) {
		data = "";
	}
	wb.close();
	fi.close();
	return data;
}

public void SetCellValue (String xlFile, String xlSheet, int rownum, int cellnum, String data) throws IOException {
	fi = new FileInputStream(xlFile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlSheet);
	wr = ws.getRow(rownum);
	cell = wr.createCell(cellnum);
	cell.setCellValue(data);
	fo = new FileOutputStream(xlFile);
	wb.write(fo);
    wb.close();
    fi.close();
    fo.close();
}


}

package com.atmecs.bookotrip.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * Take the value from excel file and passing the value to website.
 * Apache poi Supports to read value from excel file.
 * 
 * @author ranjitha.selvam
 */
public class UtilsTest {
	
	
	static Workbook book;
	static Sheet sheet;
	/*
	 * @param File Name
	 * 
	 * @param Sheet Name
	 * 
	 */
	
    public static Object[][] ReadWriteExcel(String path,String sheetName) {
		File file=new File(path);
	FileInputStream read = null;
	try {
	read = new FileInputStream(file);
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}
	try {
	book = WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
	for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	}
	}
	return data;
	}
	}





package com.example.demo.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class ReadExcelUtil {

	private ReadExcelUtil() {

	}

	public static int formatDoubleToInt(String txt) {
		return Double.valueOf(txt).intValue();
	}

	public static List<String[]> read(String fileName) {
		return read(fileName, -1 ,"UTF-8");
	}

	public static List<String[]> read(String fileName ,int sheetNum) {
		return read(fileName, sheetNum ,"UTF-8");
	}

	public static List<String[]> read(String fileName, int sheetNum ,String charset) {
		List<String[]> list = new ArrayList<String[]>();
		try {
			File uploaderFile = new File(fileName);
			String excelVesion = "";
			if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
				excelVesion = "2007";
			}

			if (fileName.matches("^.+\\.(?i)(xls)$")) {
				excelVesion = "2003";
			}

			if (fileName.matches("^.+\\.(?i)(csv)$")) {
				excelVesion = "csv";
			}

			if (fileName.matches("^.+\\.(?i)(txt)$")) {
				excelVesion = "txt";
			}
			switch (excelVesion) {
			case "2007":
				readExcel2007(list, uploaderFile, sheetNum);
				break;
			case "2003":
				readExcel2003(list, uploaderFile, sheetNum);
				break;
			case "csv":
				readCsv(list,fileName ,charset);
				break;
			case "txt":
				readTxt(list,fileName ,charset);
				break;
			}
		} catch (Exception e) {
		}
		return list;
	}

	private static void readTxt(List<String[]> list, String fileName, String charset) {
		File file=new File(fileName);
		BufferedReader reader=null;
		String temp=null;
		int line=1;
		try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),charset);
			reader=new BufferedReader(read);
			while((temp=reader.readLine())!=null){
				String[] arrs = temp.split("\\s+");
				list.add(arrs);
				line++;
			}
		}
		catch(Exception e){
		}
		finally{
			if(reader!=null){
				try{
					reader.close();
				}
				catch(Exception e){
				}
			}
		}
	}

	private static void readCsv(List<String[]> csvFileList, String csvFilePath ,String charset ) {

	}

	private static void readExcel2003(List<String[]> list, File uploaderFile, int sheetNum)
			throws IOException, FileNotFoundException {
		POIFSFileSystem pffs = null;
		HSSFWorkbook hsfw = null;
		try {
			FileInputStream is = new FileInputStream(uploaderFile);
			pffs = new POIFSFileSystem(is);
			hsfw = new HSSFWorkbook(pffs);
			HSSFSheet childSheet = null;
			if (sheetNum < 0) {
				for (int i = 0; i < hsfw.getNumberOfSheets(); i++) {
					childSheet = hsfw.getSheetAt(i);
					read2003(list, childSheet);
				}
			} else {
				childSheet = hsfw.getSheetAt(sheetNum);
				read2003(list, childSheet);
			}
		} catch (Exception e) {
		}
	}

	private static void read2003(List<String[]> list, HSSFSheet childSheet) {
		for (int j = 0; j < childSheet.getPhysicalNumberOfRows(); j++) {
			HSSFRow row = childSheet.getRow(j);
			if (row.getLastCellNum() < 0) {
				continue;
			}
			String[] str = new String[row.getLastCellNum()];
			if (null != row) {
				for (int k = 0; k < row.getLastCellNum(); k++) {
					HSSFCell cell = row.getCell(k);
					if (null != cell) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC:
							str[k] = cell.getNumericCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_STRING:
							str[k] = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							str[k] = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							try {
								str[k] = cell.getNumericCellValue() + "";
							} catch (Exception e) {
								try {
									str[k] = cell.getStringCellValue();
								} catch (Exception e1) {
									str[k] = String.valueOf(cell.getCellFormula());
								}
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							str[k] = "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							str[k] = "error";
							break;
						default:
							str[k] = "undefind  ";
							break;
						}
					} else {
						str[k] = "";
					}
				}
				list.add(str);
			}
		}
	}

	private static void readExcel2007(List<String[]> list, File uploaderFile, int sheetNum)
			throws IOException, FileNotFoundException {
		XSSFWorkbook xsfw;
		xsfw = new XSSFWorkbook(new FileInputStream(uploaderFile));
		XSSFSheet sheet;
		if (sheetNum < 0) {
			for (int i = 0; i < xsfw.getNumberOfSheets(); i++) {
				sheet = xsfw.getSheetAt(i);
				read2007(list, sheet);
			}
		} else {
			sheet = xsfw.getSheetAt(sheetNum);
			read2007(list, sheet);
		}
	}

	private static void read2007(List<String[]> list, XSSFSheet sheet) {
		for (int j = sheet.getFirstRowNum(); j < sheet.getPhysicalNumberOfRows(); j++) {
			XSSFRow row = sheet.getRow(j);
			if (row == null || row.getLastCellNum() < 1)
				continue;
			String[] str = new String[row.getLastCellNum()];
			for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
				XSSFCell cell = row.getCell(k);
				if (cell == null) {
					str[k] = "";
				} else {
					switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_STRING:
						str[k] = cell.getStringCellValue();
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						str[k] = String.valueOf(cell.getNumericCellValue());
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						str[k] = String.valueOf(cell.getBooleanCellValue());
						break;
					case XSSFCell.CELL_TYPE_FORMULA:
						try {
							str[k] = String.valueOf(cell.getNumericCellValue());
						} catch (Exception e) {
							try {
								str[k] = cell.getStringCellValue();
							} catch (Exception e1) {
								str[k] = String.valueOf(cell.getCellFormula());
							}
						}
						break;
					default:
						str[k] = "";
						break;
					}
				}
			}
			list.add(str);
		}
	}
}

package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void writeData(String incidentNo) throws IOException {
		String path = "./data/DeleteIncident.xlsx";
		FileInputStream fs = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		sheet1.getRow(1).getCell(2).setCellValue(incidentNo);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();

	}

}

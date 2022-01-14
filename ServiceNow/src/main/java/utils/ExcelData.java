package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	

	public static String[][] readData(String fileName) throws IOException {
	XSSFWorkbook wb=new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		XSSFSheet ws=wb.getSheetAt(0);
		XSSFRow row=ws.getRow(1);
		XSSFCell cell=row.getCell(0);
		int rowCount=ws.getLastRowNum();
		System.out.println("Row Count="+rowCount);
		int cellCount=row.getLastCellNum();
		System.out.println("Column Count="+cellCount);
		
		String[][] data=new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++)
		{
			
			for(int j=0;j<cellCount;j++)
			{
				String cellValue=ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cellValue);
				data[i-1][j]=cellValue;
			}
		}

		return data;
	
	}

}

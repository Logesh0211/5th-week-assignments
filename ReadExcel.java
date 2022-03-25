package week5day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		String filelocation="./testData/LoginExcel.xlsx";
		XSSFWorkbook wbook=new XSSFWorkbook(filelocation);
		XSSFSheet sheet=wbook.getSheetAt(0);
		for (int i = 1; i <=2; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < 2; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.println(value);
			} 
		}
     wbook.close();
	}

}

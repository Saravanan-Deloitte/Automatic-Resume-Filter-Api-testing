package Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {

    public String sendData(int sheetNum, int rowNum,int colNum) throws IOException {
 
        
        String excelFilePath = "C:\\Users\\yashmittal2\\Desktop\\Automatic-Resume-Filter-Api-testing\\src\\main\\resources\\apiData.xlsx";

        FileInputStream fis = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetNum);
        XSSFRow row = null;
        XSSFCell cell = null;
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        String send = cell.getStringCellValue();
        return send;
    }

}

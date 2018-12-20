package stepdefs;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelExample {
    String fileName = "positiveLoginData.xlsx";
    InputStream excel;

    @Test
    public void test() throws IOException {
        excel = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(excel);
        Sheet sheet = wb.getSheet("Sheet1");

        int size = sheet.getLastRowNum()-sheet.getFirstRowNum();

        for(int i=1; i<=size; i++){
            Row row= sheet.getRow(i);
            Cell username = row.getCell(0);
            Cell password = row.getCell(1);

            System.out.println("Username: " + username + "Password : " + password);
        }




    }

}

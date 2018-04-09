package test;

import java.io.FileInputStream;
import java.io.InputStream;

import jxl.*;

public class ParseExcel2Database {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream(".//src//student.xls");
            Workbook book = Workbook.getWorkbook(is);
            // 循环读取excel的sheet
            for (Sheet sheet : book.getSheets()) {
                int rows = sheet.getRows();
                int columns = sheet.getColumns();
                for (int i = 1; i < rows; i++) {
                    for (int j = 1; j < columns; j++) {

                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
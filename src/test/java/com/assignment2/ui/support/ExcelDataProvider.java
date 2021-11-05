package com.assignment2.ui.support;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDataProvider {

    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter = new DataFormatter();

    /**
     * This method return the Excel file Data
     * @param filePath
     * @param sheet
     * @return
     * @throws IOException
     */
    public Object[][] excelDataProvider(String filePath, String sheet) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(fileInputStream);
        worksheet = workbook.getSheet(sheet);
        XSSFRow Row = worksheet.getRow(0);
        int RowNum = worksheet.getPhysicalNumberOfRows();
        int ColNum = Row.getLastCellNum();
        Object Data[][] = new Object[RowNum - 1][ColNum];

        for (int i = 0; i < RowNum - 1; i++) {
            XSSFRow row = worksheet.getRow(i + 1);
            for (int j = 0; j < ColNum; j++) {
                if (row == null) {
                    Data[i][j] = "";
                } else {
                    XSSFCell cell = row.getCell(j);
                    if (cell == null) {
                        Data[i][j] = "";
                    } else {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j] = value;
                    }
                }
            }
        }
        return Data;
    }

    /**
     * This Method write the data in Excel file
     * @param filePath
     * @param sheetName
     * @param data
     * @param column
     * @throws IOException
     */
    public void writeExcel(String filePath, String sheetName, String data, int column) throws IOException {

        File file =    new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;

        workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(1);
        Cell cell = row.getCell(column);

        if (cell == null)
            cell = row.createCell(column);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(data);
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();

    }
}

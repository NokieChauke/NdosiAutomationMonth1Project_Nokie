package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {

    public static void createLoginDataExcel(String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("LoginData");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Email");
            headerRow.createCell(1).setCellValue("Password");
            headerRow.createCell(2).setCellValue("ExpectedMessage");

            // Create data rows
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("nokietest@mail.com");
            row1.createCell(1).setCellValue("125abc!Test");
            row1.createCell(2).setCellValue("Welcome back, Nokie! \uD83D\uDC4B");

            Row row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("invalid@email.com");
            row2.createCell(1).setCellValue("wrongpassword");
            row2.createCell(2).setCellValue("Invalid credentials");

            // Write to file
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error creating Excel file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createLoginDataExcel("src/test/resources/LoginData.xlsx");
    }
}

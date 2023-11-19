package com.clean.ults;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ExcelReaderUtls {
    private File excelFileLocation;
    private String sheetName;
    private int startRow;
    private int startColumn;
    private int totalRow;
    private int totalColumn;
    private Workbook workbook;
    private Sheet sheet;
    private FileInputStream file;

    public ExcelReaderUtls(File excelFileLocation, String sheetName, int startRow, int startColumn) {
        this.excelFileLocation = excelFileLocation;
        this.sheetName = sheetName;
        this.startRow = startRow;
        this.startColumn = startColumn;
        try{
            file=new FileInputStream(excelFileLocation);
            workbook = WorkbookFactory.create(file);
            sheet=workbook.getSheet(this.sheetName);
            totalRow=sheet.getPhysicalNumberOfRows();
            totalColumn=sheet.getRow(0).getPhysicalNumberOfCells();
            file.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getCellValue(int rowNo,int colNo){
        Row row= sheet.getRow(rowNo);
        Cell cell=row.getCell(colNo);
        String cellValue="";
        CellType cellType=cell.getCellType();
        if (cellType.equals(CellType.STRING))
            cellValue=cell.getStringCellValue();
        if (cellType.equals(CellType.NUMERIC)){
            NumberFormat nf=new DecimalFormat("#.####");
            cellValue=String.valueOf(nf.format(cell.getNumericCellValue()));

        }
        return cellValue;
    }
    public int getTotalRow(){
        return this.totalRow;
    }
    public int getTotalColumn(){
        return this.totalColumn;
    }
    public static void main(String[] args) {
        String excelFilename ="DataTest.xlsx";
        File excelFileLocation = new File(System.getProperty("user.dir")+
                "/Data/"+excelFilename);
        try{
         ExcelReaderUtls excelReaderUtls=new ExcelReaderUtls(excelFileLocation,"Sheet1",1,0);
            System.out.println(excelReaderUtls.getCellValue(1,0));
            System.out.println(excelReaderUtls.getCellValue(1,1));
            System.out.println(excelReaderUtls.getCellValue(2,0));
            System.out.println(excelReaderUtls.getCellValue(2,1));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

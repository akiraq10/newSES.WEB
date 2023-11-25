package com.clean.dataprovider;

import com.clean.ults.ExcelReaderUtls;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class DataProvider {
    private String excelFilename ="DataTest.xlsx";

    private File excelFileLocation = new File(System.getProperty("user.dir")+
            "/Data/"+excelFilename);
    @org.testng.annotations.DataProvider
    public Object[][] loginData(){
        String sheetName="Login";
        Object[][] loginData=readData(excelFileLocation,sheetName);

        return loginData;
    }
    @org.testng.annotations.DataProvider
    public Object[][] readProfileData(){
        String sheetName="Profile";
        Object[][] readProfileData=readData(excelFileLocation,sheetName);

        return readProfileData;
    }
    @org.testng.annotations.DataProvider
    public Object[][] readPackageData(){
        String sheetName="Package";
        Object[][] readProfileData=readData(excelFileLocation,sheetName);

        return readProfileData;
    }
    private Object[][] readData(File excelFileLocation, String sheetName){
        int startRowIndex=1;
        int startColumnIndex=0;
        ExcelReaderUtls excelReaderUtls=new ExcelReaderUtls(excelFileLocation,sheetName,startRowIndex,startColumnIndex);
        int totalRow=excelReaderUtls.getTotalRow();
        int totalColumn=excelReaderUtls.getTotalColumn();
        Object[][] readData=new Object[totalRow-startRowIndex][totalColumn];
        for(int startRow =startRowIndex; startRow < totalRow;startRow++){
            for (int startColumn=startColumnIndex;startColumn<totalColumn;startColumn++){
                readData[startRow-startRowIndex][startColumn]=excelReaderUtls.getCellValue(startRow,startColumn);

            }

        }
        return readData;
    }


}

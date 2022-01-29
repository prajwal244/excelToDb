package com.st;

import java.util.List;
import java.io.File;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelReadService {

	@Autowired
	SaveDataToDb repo;
	
public List<Student> ReadDataFromExcel(String excelPath) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		Workbook workbook = WorkbookFactory.create(new File(excelPath));
		// Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
            
            DataFormatter dataFormatter = new DataFormatter();
            for (Row row: sheet) {
            	String ssId= row.getCell(0).getStringCellValue();
            	String name= row.getCell(1).getStringCellValue();
            	String city= row.getCell(2).getStringCellValue();
            	String country= row.getCell(3).getStringCellValue();
            	String pin= row.getCell(4).getStringCellValue();
            	
            	
            	Student st = new Student();
            	st.setSsId(ssId);
            	st.setName(name);
            	st.setCity(city);
            	st.setCountry(country);
            	st.setPin(pin);
            	
            	repo.save(st);
            
            	   System.out.println(row.getCell(0));
            	   System.out.println(row.getCell(1));
            	   System.out.println(row.getCell(2));
            	   System.out.println(row.getCell(3));
            	   System.out.println(row.getCell(4));
            } 
            }
        return null;
}
}

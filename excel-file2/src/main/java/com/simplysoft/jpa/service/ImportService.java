package com.simplysoft.jpa.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.simplysoft.jpa.model.Student;
import com.simplysoft.jpa.repository.ImportRepository;

@Service
public class ImportService {
	
	@Autowired
	private ImportRepository irepo;

	public void saveDetail(MultipartFile file) {
		upload(file);
		
//		String excelFilePath="C:\\Users\\97798\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\excel-file\\src\\main\\resources\\static\\student.xlsx";
//		FileInputStream inputStream;

		List<Student> student = new ArrayList<Student>();
	
		try {
//			inputStream=new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(file.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			rows.next();


			while (rows.hasNext()) {
				Row currentRow = rows.next();
				Iterator<Cell> cellsInRow = currentRow.cellIterator();
				Student std = new Student();

				int cellIndex ;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					cellIndex=currentCell.getColumnIndex();
					switch (cellIndex) {
					case 0:
						std.setId((long)currentCell.getNumericCellValue());
						break;

					case 1: 
						std.setStudentName(currentCell.getStringCellValue());
						break;
					case 2:
						std.setStudentAddress(currentCell.getStringCellValue());
						break;
					case 3:
						std.setStudentClass((int)currentCell.getNumericCellValue());
						break;
				
					}
					student.add(std);

				}
				

			}
			workbook.close();

		}

		catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: "+e.getMessage());
			
		}


		irepo.saveAll(student);
	}
	
	public List<Student> getAllStudent(){
//		System.out.println("working upto here");
		return irepo.findAll();
	}
		
	
		

	 static void upload(MultipartFile file) {
		 
		 String fileName=file.getOriginalFilename();
		   Path path = Paths.get("C:\\Users\\97798\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\excel-file2\\src\\main\\resources\\static\\"+fileName);
	         
	        try {
	            byte data[]= file.getBytes();
	            Files.write(path, data);

	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
	}
	


}

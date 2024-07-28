package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	public static FileInputStream fis;
	
	public static HashMap<String,String> getTestData(String testcase) 
	{
		
		// public static FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\excels\\regression\\Adactin Master Data.xlsx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		XSSFWorkbook wb=null;
		try {
			
			
			
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet ws=wb.getSheet("com.adactin");
		ArrayList<Row> newRows=  new ArrayList<Row>();
		 newRows=getTestRows(ws, testcase);
		
		HashMap<String,String> testdataMap=new HashMap<String,String>();
		for(int i=0;i<newRows.size();i++)
		{
			 int noOfCells=newRows.get(0).getLastCellNum();
			 for(int j=1;j<noOfCells;j++)
			 {
				 testdataMap.put(newRows.get(0).getCell(j).getStringCellValue(), newRows.get(1).getCell(j).getStringCellValue());
			 }
		}
		
		return testdataMap;
		
	}
	
	
	
	public  static ArrayList<Row> getTestRows(XSSFSheet ws,String testcase)
	{
		
		ArrayList<Row> allRows=new ArrayList<Row>();
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			if(ws.getRow(i)!=null)
			{
				allRows.add(ws.getRow(i));
			}
		}
		System.out.println(allRows.size()); // 4
		
		ArrayList<Row> testrows=new ArrayList<Row>();
		
		for(int i=0;i<allRows.size();i++)
		{
			if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testcase))
			{
			 testrows.add(allRows.get(i));
			}
		}
		System.out.println(testrows.size());//2
		return testrows;
		
	}
	

}

package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsInstanceOf;

public class ExcelUtils
{
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

    	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path,String SheetName) throws Exception {
	try 
	{
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(Path);
		//System.out.println(String.valueOf(ExcelFile));
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	} catch (Exception e){
		throw (e);
	}
}
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
    	    public static String getCellData(int RowNum, int ColNum) throws Exception{
    	    	String cellData = null;
    	    	try
    	    	{
    	    		//XSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);
    	    		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
    	    		cellData = Cell.getStringCellValue();
     	}catch (Exception e){
     		if(null != Cell.getRawValue()) {
     			cellData = Cell.getRawValue().toString();
     		}else {
     			System.out.println("Exception:"+e);
     		}

     	}
    	    	System.out.println(cellData);
    	    	return cellData;
}
    		//This method is to write in the Excel cell, Row num and Col num are the parameters
    		/*public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception{
    		try
    		{
          	Row  = ExcelWSheet.getRow(RowNum);
          	Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
          	System.out.println("ColNum: "+ColNum);
          	if (Cell == null) 
          	{
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
				   }
          // Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}catch(Exception e){
		throw (e);
		}
    	}*/
    	    
    	    public static void setCellData(String text, int RowNum, int ColNum) throws Exception
    	    {
    	     try{   
    	        Row  = ExcelWSheet.getRow(RowNum);
    	        if(Row ==null)
    	        {
    	           Row = ExcelWSheet.createRow(RowNum);
    	        }
    	        Cell = Row.getCell(ColNum);
    	       if (Cell != null) 
    	        {
    	            Cell.setCellValue(text);
    	        } 
    	        else 
    	        {
    	             Cell = Row.createCell(ColNum);
    	             Cell.setCellValue(text);  
    	        }
    	       FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);
    	       ExcelWBook.write(fileOut);
    	        fileOut.flush();
    	        fileOut.close();
    	     }catch(Exception e){throw (e);
    	     } 
    	}
}
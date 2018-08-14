package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.poi.ss.usermodel.*;

import testbase.TestBase;

public class testutil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public int rowcount;
	public int columncount;

	public static String Testdata_sheet_path="C:\\SeleniumTrainingByJitendra\\practicals\\EclipseJavaPracticals\\Regression_1\\src\\main\\java\\testdata\\TestData.xlsx";
	public void switchtoframe()
	{
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String Sheetname) throws InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\SeleniumTrainingByJitendra\\practicals\\EclipseJavaPracticals\\Regression_1\\src\\main\\java\\testdata\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(Sheetname);
		Object[][] data=new Object[s.getLastRowNum()][s.getRow(0).getLastCellNum()];
		for(int i=0;i<s.getLastRowNum();i++)
		{
			for(int j=0;j<s.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=s.getRow(i+1).getCell(j).toString();
			}
		}
		return data;

	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String CurrentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(CurrentDir + "/screenshot/"+System.currentTimeMillis()+".png"));
		
	}

}

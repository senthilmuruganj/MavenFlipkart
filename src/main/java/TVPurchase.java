import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TVPurchase {

	

	
	public static void main(String[] args) throws Exception  {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUDHASEN\\eclipse-workspace\\Junit\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.flipkart.com/";
			driver.get(url);
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]")).sendKeys("9965309666");
			driver.findElement(By.xpath("(//input[@autocomplete='off'])[3]")).sendKeys("sudhasen3214@");
			driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
			Thread.sleep(3000);
			
			WebElement home = driver.findElement(By.xpath("//input[@name='q']"));
			home.sendKeys("SAMSUNG TV");
			WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
			submit.click();
			Thread.sleep(2000);
		  
		
		
		  FileOutputStream f = new FileOutputStream("C:\\Users\\SUDHASEN\\eclipse-workspace\\Junit\\src\\main\\resources\\Excel\\Test Design Template.xlsx"); 

	       HSSFWorkbook wb = new HSSFWorkbook();
	       HSSFSheet sheet = wb.createSheet("new"); 
	       
	       
	       
	       sheet.createRow(0);
	       List<WebElement> xpaths=driver.findElements(By.xpath("//*[@class='_4rR01T']"));
	       
	       
	      
	           for(WebElement ele : xpaths){ 
	               
	               String xpath = ele.getText();
	               System.out.println(xpath);
	            
	           for(int i = 0; i<=xpath.length(); i++){ 
	        	   HSSFRow row = sheet.createRow(i);
	    	       HSSFCell cell = row.createCell(0);
	    	       cell.setCellValue(xpath);
	           }
	           }
	           wb.write(f);
	           wb.close();
	           
	           driver.findElement(By.xpath("(//div[@class='_4rR01T'])[4]"));
	           Set<String> winId = driver.getWindowHandles();
	           List<String> list = new ArrayList();
	           list.addAll(winId);
	           driver.switchTo().window(list.get(1));
	           WebElement fourMob = driver.findElement(By.xpath("//span{@class='B_NuCT']"));
	           System.out.println("Fourth Mobile name is" +fourMob.getText());
	           
	           driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
	           Thread.sleep(3000);
	           
	           TakesScreenshot js = (TakesScreenshot)driver;
	   		   File sa=js.getScreenshotAs(OutputType.FILE);
	   		   String title= driver.getTitle();
	   		   File tar= new File("C:\\Users\\SUDHASEN\\eclipse-workspace\\Junit\\screenshot\\flipcart.png");
	   		   FileUtils.copyFile(sa, tar);
	}
}

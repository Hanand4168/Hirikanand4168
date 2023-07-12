package sel2jave;

import java.sql.Driver;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class main {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		 System.setProperty("Webdriver.Chromw.Driver","C:\\Users\\hirik\\Downloads\\chromedriver_win32\\chromedriver.exe");
	     WebDriver Driver= new ChromeDriver(option);
	     WebDriverWait w=new WebDriverWait(Driver,Duration.ofSeconds(7)); 
	     
	     Driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        
         Driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Walnut");
         Driver.findElement(By.xpath("//button[@class='search-button']")).click();
         
         w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product']")));
         Assert.assertEquals(Driver.findElement(By.xpath("//div[@class='product']/h4")).getText() , "Walnuts - 1/4 Kg");    
         
       
        Driver.findElement(By.xpath("//div[@class='product']/div[@class='product-action']/button")).click();
        Driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        Driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
        Driver.findElement(By.xpath("//p[@class='product-name']")).getText(); 
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='products']")));
        
       System.out.println(Driver.findElement(By.xpath("//p[@class='product-name']")).getText()); 
       Assert.assertEquals(Driver.findElement(By.xpath("//p[@class='product-name']")).getText() , "Walnuts - 1/4 Kg");    
       Thread.sleep(5500);
       
       
         
         
         //   Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));         
	    // Driver.close();

	}
	

}

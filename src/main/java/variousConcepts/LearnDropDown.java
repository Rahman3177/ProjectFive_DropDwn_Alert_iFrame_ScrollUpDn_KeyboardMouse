package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {

	WebDriver driver;

	@Before 
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void dropDownTest() {

		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//span[contains(text(), 'Customers')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Add Customer')]")).click();
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Luthfor Rahman");
		
//		driver.findElement(By.xpath("//select[@name='cid']"));
//Here we are putting above Xpath in a WebElement variable
		WebElement companyDropDown = driver.findElement(By.xpath("//select[@name='cid']"));
		Select sel = new Select(companyDropDown);
		sel.selectByVisibleText("Tesla");
// This method will give you all the DropDown options		
	//	sel.getOptions();	
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("luthfor.r@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("abc123");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("2 Amato Drive");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("South Windsor");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Connecticut");
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("06074");
		driver.findElement(By.id("submit")).click();
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}

}

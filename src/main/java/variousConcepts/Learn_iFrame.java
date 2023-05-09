package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learn_iFrame {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void iFrameTest() {
		driver.switchTo().frame("packageListFrame");
//		driver.findElement(By.linkText("java.awt")).click();
		driver.findElement(By.linkText("java.awt.color")).click();

//Here we are switching the frame 		
		driver.switchTo().parentFrame(); //Here we back to ParentFrame and then jump to next Frame
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("ColorSpace")).click();
		
		driver.switchTo().parentFrame(); //Here we back to ParentFrame and then jump to next Frame
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("java.lang.Object")).click();
	}

//	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}

}
package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnPopUpAlerts {
	WebDriver driver;

	@Before 
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void popUpAlertTest() {
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg); // This is to Print out the ALERT masg in the console
		driver.switchTo().alert().accept();
	//	driver.switchTo().alert().dismiss();
	//	driver.switchTo().alert().sendKeys("ThankU");
	}

//	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}
}

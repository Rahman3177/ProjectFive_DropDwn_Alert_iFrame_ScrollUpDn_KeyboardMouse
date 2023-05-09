package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUpDown {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Test
	public void scrollUpDownTest() {		
//		JavascriptExecutor js = new JavascriptExecutor(); // Here we dont need to use key word "new"
// We need to apply "Java Casting."
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,3000)"); //Here 0 is 'y' axis and 3000 is 'x' axis

	}

//	@After
	public void tearDown() throws InterruptedException {
		driver.close();
		driver.quit();

	}

}

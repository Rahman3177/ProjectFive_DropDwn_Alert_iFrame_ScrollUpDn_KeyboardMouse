package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverOver {
WebDriver driver;
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void mouseHoverOverTest() {
		WebElement PRODUCT_Menu = driver.findElement(By.xpath("//*[@id='unified-masthead-navigation']/nav/ul/li[2]/button"));
		WebElement PRODUCT_Monitors = driver.findElement(By.xpath("//*[@id=\'unified-masthead-navigation\']/nav/ul/li[2]/ul/li[3]/button"));
		
		Actions action = new Actions(driver);
		action.moveToElement(PRODUCT_Menu).build().perform();
		action.moveToElement(PRODUCT_Monitors).build().perform();
	
// If something is not hovering then we dont need ".build().perform()" we can simply use .click()
// More operation examples are there in the PPT		
				
	}

//	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}
}

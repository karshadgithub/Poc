package AutomationPractice.POC;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--allow-running-insecure-content");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(url);
		
	}

	@Test
	public void Registration()
	{
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("karshad66@gmail.com");
		///*[@id="SubmitCreate"]/span
		//*[@id="SubmitCreate"]/span
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
		//id_gender1
		driver.findElement(By.id("id_gender1")).click();
		//id_gender1
		driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Arshad");
		
		driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Khan");
		
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Test@123");
		Select days = new Select(driver.findElement(By.cssSelector("#days")));
		days.selectByIndex(1);
		Select months = new Select(driver.findElement(By.cssSelector("#months")));
		months.selectByIndex(2);
		Select years = new Select(driver.findElement(By.cssSelector("#years")));
		years.selectByIndex(29);
		driver.findElement(By.cssSelector("#firstname")).sendKeys("Arshad");
		driver.findElement(By.cssSelector("#lastname")).sendKeys("Khan");
		driver.findElement(By.cssSelector("#company")).sendKeys("Company1");
		driver.findElement(By.cssSelector("#address1")).sendKeys("Test123");
		driver.findElement(By.cssSelector("#city")).sendKeys("Testc");
		Select state = new Select(driver.findElement(By.cssSelector("#id_state")));
		state.selectByIndex(1);
		driver.findElement(By.cssSelector("#postcode")).sendKeys("35006");
		driver.findElement(By.cssSelector("#other")).sendKeys("This is test details");
		
		driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("+971506458593");
		
		driver.findElement(By.cssSelector("#alias")).clear();
		driver.findElement(By.cssSelector("#alias")).sendKeys("Test2");
		
		
		driver.findElement(By.cssSelector("#submitAccount > span")).click();
		driver.findElement(By.className("logout")).click();;
		
		
	}
	
	@Test(priority = 1)
	public void login()
	{
		driver.findElement(By.className("login")).click();
		
		driver.findElement(By.cssSelector("#email")).sendKeys("karshad66@gmail.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Test@123");
		driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
	}
	
	@Test(priority = 2)
	public void buyProduct() throws InterruptedException {
	driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img")).click();
	Thread.sleep(5000);
	System.out.println(driver.getTitle());
	driver.findElements(By.tagName("iframe")).size();
	
		WebDriver fm = driver.switchTo().frame(0);
		System.out.println("fm "+fm);
		driver.findElement(By.cssSelector("#add_to_cart > button > span")).click();
		

	
	}
	
@AfterTest
public void testRegistration()
{
	driver.quit();
}
}

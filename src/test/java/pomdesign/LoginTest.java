package pomdesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.LoginPage;
import objectrepository.MyAccontPage;

public class LoginTest {
	WebDriver driver;
	
	@Test
	public void login() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		LoginPage login = new LoginPage(driver);
		login.emailField().sendKeys("arun.selenium@gmail.com");
		login.passwordField().sendKeys("Second@123");
		login.loginAccount().click();
				
				
		MyAccontPage myaccountpage= new  MyAccontPage(driver);
		Assert.assertTrue(myaccountpage.accountBreadCrumb().isDisplayed()); 
	
		
		
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
		
	}
}

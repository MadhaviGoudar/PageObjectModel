package pomdesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.LoginPage;
import objectrepository.MyAccontPage;

public class LoginTest {
	WebDriver driver;
	
	@Test(dataProvider ="loginTestData")
	public void login(String userName , String password) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		LoginPage login = new LoginPage(driver);
		login.emailField().sendKeys(userName);
		login.passwordField().sendKeys(password);
		login.loginAccount().click();
				
				
		MyAccontPage myaccountpage= new  MyAccontPage(driver);
		Assert.assertTrue(myaccountpage.accountBreadCrumb().isDisplayed()); 
		Thread.sleep(5000);
		driver.quit();
	
		
		
	}

	@DataProvider(name="loginTestData")
	public Object[][] loginData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="madhavi.goudar007@gmail.com";
		data[0][1]="Madhu@12345";
		
		data[1][0]="Madhu";
		data[1][1]="Second@123";
		
		return data;
		
		
	} 
}
	
	
	/*@AfterMethod
	public void closure()
	{
		driver.close();
		
	}
	
	
}*/

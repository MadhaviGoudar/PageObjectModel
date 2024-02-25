package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver )
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(css="input[value='Login']")
	private WebElement loginAccount;
	
	//private By emailField =  By.id("input-email");
	//private By passwordField = By.id("input-password");
	//private By loginAccount = By.cssSelector("input[value='Login']");
	

	public WebElement emailField()
	{
		return emailField;
		
	}
	
	public WebElement passwordField()
	{
		return passwordField;
		
	}
	public WebElement loginAccount()
	{
		return loginAccount;
		
	}

}

package grocerypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import groceryutilities.WaitUtility;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	WaitUtility wu=new WaitUtility();
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement pswrd;
	@FindBy(xpath="//button[text()='Sign In']") WebElement login;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement logintext;
	
	public LoginPage enterUserName(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
		return this;
	}
	
	public LoginPage enterpswrd(String pswrdvalue)
	{
		pswrd.sendKeys(pswrdvalue);
		return this;
	}
	
	public HomePage clickSubmit() 
	{
		wu.waitUntilElementToBeClickable(driver, login);
		login.click();
		return new HomePage(driver);
	}
	
	public boolean isDashBoardDisplayed()
	{
		return dashboard.isDisplayed();
	}
	
	public String isTextDisplayed()
	{
		return logintext.getText();
	}
	
}

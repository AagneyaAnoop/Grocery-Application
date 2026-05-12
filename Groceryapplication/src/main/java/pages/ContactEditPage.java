package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ContactEditPage {
	
	public WebDriver driver;
	
	public ContactEditPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	PageUtility pu=new PageUtility();
	
	@FindBy(id="phone") WebElement phoneno;
	@FindBy(id="email") WebElement email;
	@FindBy(name="address") WebElement address;
	@FindBy(name="Update") WebElement updatebtn;
	@FindBy(xpath="//button[@class='close']") WebElement alertclosebtn;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']") WebElement action;
	
	public ContactEditPage clickAction()
	{
		action.click();
		return this;
	}
	
	public ContactEditPage enterPhoneNo(String phnNo)
	{
		phoneno.clear();
		phoneno.sendKeys(phnNo);
		return this;
	}
	
	public ContactEditPage enterEmailId(String emailid)
	{
		email.clear();
		email.sendKeys(emailid);
		return this;
	}
	
	public ContactEditPage enterAddress(String adr)
	{
		address.clear();
		address.sendKeys(adr);
		return this;
	}
	
	public ContactEditPage clickUpdateBtn() 
	{
		pu.clickByJavaScriptExector(driver, updatebtn);
		return this;
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", updatebtn);
	}
	
	public boolean checkAlertisDisplayed()
	{
		return alertclosebtn.isDisplayed();
	}
	
}

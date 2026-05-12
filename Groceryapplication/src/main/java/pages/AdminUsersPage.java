package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	PageUtility pu=new PageUtility();
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement btnnew;
	@FindBy(id="username") WebElement usernamenew;
	@FindBy(id="password") WebElement pswrdnew;
	@FindBy(id="user_type") WebElement usertype;
	@FindBy(name="Create") WebElement btnsave;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement btnsearch;
	@FindBy(id="un") WebElement srchusername;
	@FindBy(id="ut") WebElement srchusertype;
	@FindBy(name="Search") WebElement btnsearchuser;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement tbldatausername;
	
	public AdminUsersPage clickBtnNew()
	{
		btnnew.click();
		return this;
	}
	
	public AdminUsersPage enterNewUserName(String newusernamevalue)
	{
		usernamenew.sendKeys(newusernamevalue);
		return this;
	}
	
	public AdminUsersPage enterNewPswrd(String newpswrdvalue)
	{
		pswrdnew.sendKeys(newpswrdvalue);
		return this;
	}
	
	public AdminUsersPage selectUserType()
	{
		pu.selectByVisibleText(usertype, "Admin");
		return this;
		
		//Select select =new Select(usertype);
		//select.selectByVisibleText("Admin");
	}
	
	public AdminUsersPage clickBtnSave()
	{
		btnsave.click();
		return this;
	}
	
	public String isalertdisplayed()
	{
		return alert.getText();
	}
	
	public AdminUsersPage clickBtnSearch()
	{
		btnsearch.click();
		return this;
	}
	
	public AdminUsersPage enterSearchUserName(String searchusernamevalue)
	{
		srchusername.sendKeys(searchusernamevalue);
		return this;
	}
	
	public AdminUsersPage selectSearchUserType()
	{
		pu.selectByVisibleText(srchusertype, "Admin");
		return this;
		
		//Select select=new Select(srchusertype);
		//select.selectByVisibleText("Admin");
	}
	
	public AdminUsersPage clickBtnSearchUser()
	{
		btnsearchuser.click();
		return this;
	}
	
	public String isDataDisplayesinTbl()
	{
		return tbldatausername.getText();
	}

}

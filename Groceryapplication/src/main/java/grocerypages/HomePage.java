package grocerypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement moreinfo;
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']") WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") WebElement managecontact;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement managenews;
	
	public HomePage clickAdmin()
	{
		admin.click();
		return this;
	}
	
	public LoginPage clickLogout() 
	{
		logout.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage clickMoreInfo() 
	{
		moreinfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ContactEditPage clickManageContact()
	{
		managecontact.click();
		return new ContactEditPage(driver);
	}
	
	public ManageNewsPage clickManagenewsMoreInfo()
	{
		managenews.click();
		return new ManageNewsPage(driver);
	}

}

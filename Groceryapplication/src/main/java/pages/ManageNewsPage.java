package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbtn;
	@FindBy(id="news") WebElement textnews;
	@FindBy(name="create") WebElement savebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertmsg;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchbtn;
	@FindBy(name="un") WebElement texttitle;
	@FindBy(name="Search") WebElement titlesearchbtn;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement tablefirstdata;
	
	public ManageNewsPage clickNewBtn()
	{
		newbtn.click();
		return this;
	}
	
	public ManageNewsPage enterNews(String newnews)
	{
		textnews.sendKeys(newnews);
		return this;
	}
	
	public ManageNewsPage clickSaveBtn()
	{
		savebtn.click();
		return this;
	}
	
	public boolean isAlertMessageDisplayed()
	{
		return alertmsg.isDisplayed();
	}
	
	public ManageNewsPage clickSearchBtn()
	{
		searchbtn.click();
		return this;
	}
	
	public ManageNewsPage enterTitleText(String newstitle)
	{
		texttitle.sendKeys(newstitle);
		return this;
	}
	
	public ManageNewsPage clickTitleSearchBtn()
	{
		titlesearchbtn.click();
		return this;
	}
	
	public String getTextofTableFirstData()
	{
		return tablefirstdata.getText();
	}

}

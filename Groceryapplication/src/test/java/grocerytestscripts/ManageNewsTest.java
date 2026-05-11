package grocerytestscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import grocerycore.GroceryBase;
import grocerypages.HomePage;
import grocerypages.LoginPage;
import grocerypages.ManageNewsPage;
import groceryutilities.ExcelUtility;

public class ManageNewsTest extends GroceryBase {
	
	HomePage hp;
	ManageNewsPage mnp;
	
	@Test(description="User is trying to add a new news")
	public void verifyUserisAbletoAddaNewNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginTestData");
		String pswrdvalue=ExcelUtility.getStringData(0, 1, "LoginTestData");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(usernamevalue).enterpswrd(pswrdvalue);
		hp=lpg.clickSubmit();
		
		mnp=hp.clickManagenewsMoreInfo();
		
		String newnewsdata=ExcelUtility.getStringData(0, 0, "NewsUpdateData");
		mnp.clickNewBtn().enterNews(newnewsdata).clickSaveBtn();
		
		boolean isdisplayesvalue=mnp.isAlertMessageDisplayed();
		Assert.assertTrue(isdisplayesvalue, Constant.ADDANEWNEWSASSERTIONMSG);
	}
	
	@Test(description="User is trying to serch a news with its title")
	public void verifyUserisAbletoSearchaNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginTestData");
		String pswrdvalue=ExcelUtility.getStringData(0, 1, "LoginTestData");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(usernamevalue).enterpswrd(pswrdvalue);
		hp=lpg.clickSubmit();
		
		mnp=hp.clickManagenewsMoreInfo();
		
		String newstitlevalue=ExcelUtility.getStringData(0, 0, "NewsUpdateData");
		mnp.clickSearchBtn().enterTitleText(newstitlevalue).clickTitleSearchBtn();
		
		String actual=mnp.getTextofTableFirstData();
		String expected="Obsquera zone";
		Assert.assertEquals(actual, expected, Constant.SEARCHANEWNEWSASSERTIONMSG);
	}

}

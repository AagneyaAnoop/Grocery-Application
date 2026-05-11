package grocerytestscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import grocerycore.GroceryBase;
import grocerypages.HomePage;
import grocerypages.LoginPage;
import groceryutilities.ExcelUtility;

public class HomeTest extends GroceryBase {
	
	HomePage hpg;
	
	@Test(description="User is trying to logout from home page")
	public void verifyUserisAbletoLogoutSuccessfullyfromtheHomePage() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginTestData");
		String pswrdvalue=ExcelUtility.getStringData(0, 1, "LoginTestData");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(usernamevalue).enterpswrd(pswrdvalue);
		hpg=lpg.clickSubmit(); 
		hpg.clickAdmin();
		lpg=hpg.clickLogout();
		
		String expected="7rmart supermarket";
		String actual=lpg.isTextDisplayed();
		Assert.assertEquals(expected, actual, Constant.LOGOUTASSERTIONMSG);
	}
}

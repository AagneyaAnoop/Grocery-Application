package grocerytestscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import grocerycore.GroceryBase;
import grocerypages.HomePage;
import grocerypages.LoginPage;
import groceryutilities.ExcelUtility;

public class LoginTest extends GroceryBase {
	
	HomePage home;
	
	@Test(priority=1, description="User is trying to login with valid credentials", groups= {"smoke"})
	public void verifyLoginWithValidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginTestData");
		String pswrdvalue=ExcelUtility.getStringData(0, 1, "LoginTestData");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(usernamevalue).enterpswrd(pswrdvalue);
		home=lpg.clickSubmit();
		boolean dashboardvalue=lpg.isDashBoardDisplayed();
		Assert.assertTrue(dashboardvalue, Constant.VALIDCREDENTIALERROR);
	}
	
	@Test(priority=2, description="User is trying to login with valid user name and invalid password", retryAnalyzer=retry.Retry.class)
	public void verifyLoginWithValidUsernameandInvalidPswrd() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(10, 0, "LoginTestData");
		String pswrdvalue=ExcelUtility.getStringData(1, 1, "LoginTestData");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(usernamevalue).enterpswrd(pswrdvalue).clickSubmit();
		String expected="7rmart supermarket";
		String actual=lpg.isTextDisplayed();
		Assert.assertEquals(actual, expected, Constant.VALIDUSERNAMEANDINVALIDPSWRD);
	}
	
	@Test(priority=3, description="User is trying to login with invalid user name and valid password")
	public void verifyLoginWithInvalidUsernameandValidPswrd() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(2, 0, "LoginTestData");
		String pswrdvalue=ExcelUtility.getStringData(2, 1, "LoginTestData");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(usernamevalue).enterpswrd(pswrdvalue).clickSubmit();
		String expected="7rmart supermarket";
		String actual=lpg.isTextDisplayed();
		Assert.assertEquals(actual, expected, Constant.INVALIDUSERNAMEANDVALIDPSWD);
	}
	
	@Test(priority=4, description="User is trying to login with Invalid Credentials", groups= {"smoke"}, dataProvider="loginProvider")
	public void verifyLoginWithInvalidUsernameandPswrd(String usernamevalue, String pswrdvalue) throws IOException
	{
		//String usernamevalue=ExcelUtility.getStringData(3, 0, "LoginTestData");
		//String pswrdvalue=ExcelUtility.getStringData(3, 1, "LoginTestData");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(usernamevalue).enterpswrd(pswrdvalue).clickSubmit();
		String expected="7rmart supermarket";
		String actual=lpg.isTextDisplayed();
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALSERRORMSG);
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}

}

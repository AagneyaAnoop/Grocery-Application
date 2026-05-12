package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import grocerycore.GroceryBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends GroceryBase {
	
	HomePage hp;
	AdminUsersPage aup;
	
	@Test(description="User is trying to add a new user")
	public void verifyWhetherUserisAbletoAddaNewUser() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginTestData");
		String pswrdvalue=ExcelUtility.getStringData(0, 1, "LoginTestData");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(usernamevalue).enterpswrd(pswrdvalue);
		hp=lpg.clickSubmit();
		
		aup=hp.clickMoreInfo();
		
		RandomDataUtility rdu=new RandomDataUtility();
		String newusernamevalue=rdu.randomUserName();
		String newpswrdvalue=rdu.randomPassword();
		aup.clickBtnNew().enterNewUserName(newusernamevalue).enterNewPswrd(newpswrdvalue).selectUserType().clickBtnSave();
		
		String expected="Alert!";
		String actual=aup.isalertdisplayed();
		Assert.assertEquals(actual, expected, Constant.NEWUSERADDEDASSERTIONMSG);
	}
	
	@Test(description="User is trying to search already added user details")
	public void verifyWhetherUserisAbletoSearchaUserDetails() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginTestData");
		String pswrdvalue=ExcelUtility.getStringData(0, 1, "LoginTestData");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(usernamevalue).enterpswrd(pswrdvalue);
		hp=lpg.clickSubmit();
		
		aup=hp.clickMoreInfo();
		
		String searchusernamevalue=ExcelUtility.getStringData(0, 0, "AdminUsersTestData");
		aup.clickBtnSearch().enterSearchUserName(searchusernamevalue).selectSearchUserType().clickBtnSearchUser();
		
		String Expected=searchusernamevalue;
		String actual=aup.isDataDisplayesinTbl();
		Assert.assertEquals(Expected, actual, Constant.SEARCHUSERDETAILSASSERTIONMSG);
	}

}

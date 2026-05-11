package grocerytestscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import grocerycore.GroceryBase;
import grocerypages.ContactEditPage;
import grocerypages.HomePage;
import grocerypages.LoginPage;
import groceryutilities.ExcelUtility;
import groceryutilities.RandomDataUtility;

public class ContactEditTest extends GroceryBase {
	
	HomePage hp;
	ContactEditPage cep;
	
	@Test(description="User is trying to edit a contcat details")
	public void verifyUserisAbletoEditContactDetails() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginTestData");
		String pswrdvalue=ExcelUtility.getStringData(0, 1, "LoginTestData");
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(usernamevalue).enterpswrd(pswrdvalue);
		hp=lp.clickSubmit();
		
		cep=hp.clickManageContact();
		
		RandomDataUtility rdu=new RandomDataUtility();
		String phoneNo=rdu.randomMobileNo();
		String emailid=rdu.randomEmailId();
		String adr=ExcelUtility.getStringData(0, 0, "ContactData");
		cep.clickAction().enterPhoneNo(phoneNo).enterEmailId(emailid).enterAddress(adr).clickUpdateBtn();	
		
		boolean alertbuttonvalue=cep.checkAlertisDisplayed();
		Assert.assertTrue(alertbuttonvalue, Constant.EDITCONTACTDETAILSASSERTIONMSG);
	}

}

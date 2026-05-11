package constant;

public class Constant {
	
	public static final String CONFIGFILE=System.getProperty("user.dir") + "\\src\\main\\resources\\confg.property";
	public static final String TESTDATA=System.getProperty("user.dir") + "\\src\\test\\resources\\GroceryTestData.xlsx";
	public static final String VALIDCREDENTIALERROR="User is unable to login with valid credentials";
	public static final String VALIDUSERNAMEANDINVALIDPSWRD="User is able to login with invalid password";
	public static final String INVALIDUSERNAMEANDVALIDPSWD="User is able to login with invalid user name";
	public static final String INVALIDCREDENTIALSERRORMSG="User is able to login with invalid credentials";
	public static final String LOGOUTASSERTIONMSG="User is able to successfully logout";
	public static final String NEWUSERADDEDASSERTIONMSG="User is successfully able to create a new user";
	public static final String SEARCHUSERDETAILSASSERTIONMSG="Searched user data successfully displayed in table";
	public static final String EDITCONTACTDETAILSASSERTIONMSG="Contact list updated successfully";
	public static final String ADDANEWNEWSASSERTIONMSG="User is successfully added a new news";
	public static final String SEARCHANEWNEWSASSERTIONMSG="User is able to serach a news";

}

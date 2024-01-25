package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AppBaseTest {

	
	@Test
	public void tc_01LoginPassFail() {
		loginPage.closeCookies();
		loginPage.moveToSignin();
		loginPage.login("kobi@gmail.com", "zivziv1998");
		String expected = "Unable to log in with provided credentials.";
		String actual =loginPage.errorMesg();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void tc_02Login() {
		loginPage.login("kobiziv10@gmail.com", "Zivziv123");
		String expected = "Hi, kobi";
		String actual =loginPage.loginSuccessMsg();
		Assert.assertEquals(actual, expected);
	}	
}

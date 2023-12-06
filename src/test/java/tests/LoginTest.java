package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {

	
	@Test
	public void tc_01LoginPassFail() {
		LoginPage lp = new LoginPage(driver);
		lp.closeCookies();
		lp.moveToSignin();
		lp.login("kobi@gmail.com", "zivziv1998");
		String expected = "Unable to login with provided credentials.";
		String actual =lp.errorMesg();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void tc_02Login() {
		LoginPage lp = new LoginPage(driver);
		lp.login("kobiziv10@gmail.com", "Zivziv123");
		String expected = "Hi, kobi";
		String actual =lp.loginSuccessMsg();
		Assert.assertEquals(actual, expected);
	}
	
}

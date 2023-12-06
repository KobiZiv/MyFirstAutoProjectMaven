package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.SignupPage;

public class SignupTest extends BaseTest {

	@Test
	public void tc_01MoveToSignIn() {
		MainPage mp = new MainPage(driver);
		mp.moveToLogin();
		LoginPage lp = new LoginPage(driver);
		lp.moveToSignup();
	}

	@Test
	public void tc_02SignInFirstNameFail() {
		SignupPage sp = new SignupPage(driver);
		sp.signup("1321", "nakash", "kobi1@gmail.com", "ZivZiv12");
		String expected = "This field should not contain digits";
		String actual = sp.errorFirstNameMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void tc_03SignInLastNameFail() {
		SignupPage sp = new SignupPage(driver);
		sp.signup("kobi", "1234", "kobi1@gmail.com", "ZivZiv12");
		String expected = "This field should not contain only digits";
		String actual = sp.errorLastNameMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void tc_04SignInEmailFail() {
		SignupPage sp = new SignupPage(driver);
		sp.signup("kobi", "ziv", "kobigmail.com", "ZivZiv12");
		String expected = "Please enter a valid email address";
		String actual = sp.errorEmailMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void tc_05SignInPasswordFail() {
		SignupPage sp = new SignupPage(driver);
		sp.signup("kobi", "ziv", "kobi1@gmail.com", "zivziv12");
		String expected = "Incorrect password";
		String actual = sp.errorPasswordMsg();
		Assert.assertEquals(actual, expected);
	}

//	@Test
//	public void tc_06SignInSuccessful() {
//		SignupPage sp = new SignupPage(driver);
//		sp.signup("kobi", "ziv", "kobi26@gmail.com", "Zivziv12");
//		String expected = "Confirmation was sent";
//		String actual = sp.confirmationMsg();
//		Assert.assertEquals(actual, expected);
//	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignupTest extends AppBaseTest {

	@Test
	public void tc_01MoveToSignIn() {
		mainPage.closeCookies();
		mainPage.moveToLogin();
		loginPage.moveToSignup();
	}

	@Test(dataProvider = "getData", description = "use incorect login information")
	public void tc_02TestCases(String firstName, String lastName, String email, String password, String expected) {
		// login fail
		// Using the variables we get from the @DataProvider method
		signupPage.signup(firstName, lastName, email, password);
		String actual = signupPage.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = {
				{ "#$@#", "ziv", "kobi@1234gmail.com", "Kobi1123",
				"This field cannot contain only special characters" },
				{ "kobi", "1235", "kobi@785gmail.com", "Kobi1123", "This field should not contain digits" },
				{ "kobi", "ziv", "kobigmail.com", "Kobi1123", "Please enter a valid email address" },
				{ "kobi", "ziv", "kobi@745gmail.com", "$$$$", "Incorrect password" }, };
		return myData;
	}

	@Test
	public void tc_03SignInSuccessful() {
		signupPage.signup("kobi", "ziv", "kobi231@gmail.com", "Zivziv12");
		String expected = "Confirmation was sent";
		String actual = signupPage.confirmationMsg();
		Assert.assertEquals(actual, expected);
	}
}

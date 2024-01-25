package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage {

	// login
	@FindBy(css = ".nav-right__user .btn-dark-blue")
	private WebElement signInBtn;
	@FindBy(css = "#email")
	private WebElement emailField;
	@FindBy(css = "[name='password']")
	private WebElement passwordField;
	@FindBy(css = "[type='submit']")
	private WebElement loginBtn;

	// validation
	@FindBy(css = ".form-error")
	private WebElement errorPass;
	@FindBy(css = ".nav-right__user-profile >.btn")
	private WebElement successMeg;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String password) {
		fillTextClearAllText(emailField, email);
		fillTextClearAllText(passwordField, password);
		click(loginBtn);
	}

	public String errorMesg() {
		waitUntilElementToBeClickable(errorPass);
		return getText(errorPass);
	}

	public String loginSuccessMsg() {
		waitUntilElementToBeClickable(successMeg);
		return getText(successMeg);
	}

	public void moveToSignin() {
		click(signInBtn);
	}

}
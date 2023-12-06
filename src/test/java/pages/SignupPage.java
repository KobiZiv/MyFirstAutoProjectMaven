package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends MainPage {

	// singIn
	@FindBy(css = "#name")
	private WebElement firstNameField;
	@FindBy(css = "#surname")
	private WebElement lastNameField;
	@FindBy(css = "#email")
	private WebElement emailField;
	@FindBy(css = "[name='password']")
	private WebElement passwordField;
	@FindBy(css = ".point__checkmark")
	private WebElement checkBoxSignup;
	@FindBy(css = "[type='submit']")
	private WebElement submitBtn;
	@FindBy(css = ".input__password-toggle>.vector-icon")
	private WebElement showPassword;
//	@FindBy(css = ".sign-up-form__login-button>span")
//	private WebElement backToLoginBtn;
	// validation
	@FindBy(css = ".sign-up-form__fields-name .form-error-message")
	private WebElement errorFirstName;
	@FindBy(css = ".sign-up-form__fields-last-name div.form-error-message")
	private WebElement errorLastName;
	@FindBy(css = ".form-error-message")
	private WebElement errorEmail;
	@FindBy(css = ".form-error-message")
	private WebElement errorPassword;
	@FindBy(css = ".sign-up-success__title")
	private WebElement signUpSucc;

	public SignupPage(WebDriver driver) {
		super(driver);
	}

	public void signup(String firstName, String lastName, String email, String password) {
		fillTextClearAllText(firstNameField, firstName);
		fillTextClearAllText(lastNameField, lastName);
		fillTextClearAllText(emailField, email);
		fillTextClearAllText(passwordField, password);
		click(showPassword);
		click(checkBoxSignup);
		click(submitBtn);
	}
	
	// validation
	public String errorFirstNameMsg() {
		waitUntilElementToBeClickable(errorFirstName);
		return getText(errorFirstName);
	}

	public String errorLastNameMsg() {
		waitUntilElementToBeClickable(errorLastName);
		return getText(errorLastName);
	}
	public String errorEmailMsg() {
		waitUntilElementToBeClickable(errorEmail);
		return getText(errorEmail);
	}
	public String errorPasswordMsg() {
		waitUntilElementToBeClickable(errorPassword);
		return getText(errorPassword);
	}
	public String confirmationMsg() {
		waitUntilElementToBeClickable(signUpSucc);
		return getText(signUpSucc);
	}
}

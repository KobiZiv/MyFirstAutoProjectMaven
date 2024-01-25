package pages;

import org.openqa.selenium.By;
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
	// @FindBy(css = ".sign-up-form__login-button>span")
	// private WebElement backToLoginBtn;

	// validation
	@FindBy(css = ".form-error-message")
	private WebElement errorFirstName;
	@FindBy(css = ".sign-up-form__fields-last-name div.form-error-message")
	private WebElement errorLastName;

	@FindBy(css = ".form-error-message")
	private WebElement errorEmail;
	// private WebElement errorEmail;

	@FindBy(css = ".form-error-message")
	private WebElement errorPassword;
	// private WebElement errorPassword;

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
		WebElement checkBoxFrame = driver.findElement(By.id("sign-up-form__accept-terms"));
		String inputValue = checkBoxFrame.getAttribute("checked");
		{
			if (inputValue != null) {
				// The "checked" attribute is present
			} else {
				// The "checked" attribute is not present
				click(checkBoxSignup);
			}
		}
		click(submitBtn);
	}

	public String getErrorMsg() {
		String error = "";
		try {
			waitUntilElementToBeClickable(errorFirstName);
			error = getText(errorFirstName);
		} catch (Exception e) {
		}
		try {

			error = getText(errorLastName);
		} catch (Exception e) {
		}
		try {
			waitUntilElementToBeClickable(errorEmail);
			error = getText(errorEmail);
		} catch (Exception e) {
		}
		try {
			waitUntilElementToBeClickable(errorPassword);
			error = getText(errorPassword);
		} catch (Exception e) {
		}
		return error;
	}

	public String confirmationMsg() {
		waitUntilElementToBeClickable(signUpSucc);
		return getText(signUpSucc);
	}
}

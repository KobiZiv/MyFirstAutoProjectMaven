package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaTourEiffelPage extends MainPage {

	@FindBy(css = ".poi-hero__title")
	private WebElement pageTitle;

	public LaTourEiffelPage(WebDriver driver) {
		super(driver);
	}

	public boolean isEiffelTower() {
		if (getText(pageTitle).equalsIgnoreCase("Eiffel Tower")) {
			return true;
		}
		return false;
	}
}

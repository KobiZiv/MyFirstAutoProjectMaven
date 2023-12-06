package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JourneyDatesPage extends BasePage {

	// flexiable dates
	@FindBy(css = ".search-dates-menu > div.search-dates-menu__controls > button")
	private WebElement flexDatesBtn;
	@FindBy(css = ".dates-form__submit>.btn-blue.btn")
	private WebElement nextBtn;

	// move to next month Btn
	@FindBy(css = ".flatpickr-next-month > svg")
	private WebElement nextMonthBtn;

	// move to previous month Btn
	@FindBy(css = ".flatpickr-prev-month > svg")
	private WebElement previousMonthBtn;

	public JourneyDatesPage(WebDriver driver) {
		super(driver);
	}

	public void setFlexDates() {
		click(flexDatesBtn);
	}

//	public void moveToNextMonth() {
//		click(nextMonthBtn);
//	}
//
//	public void moveBackAmonth() {
//		click(previousMonthBtn);
//	}
//
//	public void clickNext() {
//		click(previousMonthBtn);
//	}
}
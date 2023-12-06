package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripPurposePage extends MainPage{

	//	next step Btn
	@FindBy (css=".btn-blue.btn")
	private WebElement nextBtn;
	//list
	@FindBy(css = ".search-purpose__item")
	private List<WebElement> areaPurposeList;
	
	public TripPurposePage(WebDriver driver) {
		super(driver);
	}


	public void goToInterestsPage() {
		click(nextBtn);
	}
	public void chooseTripPurpose(String name) {
		for (WebElement area : areaPurposeList) {
			WebElement titleEl = area.findElement(By.tagName("span"));
			if (getText(titleEl).equalsIgnoreCase(name)) {
				click(titleEl);
				click(nextBtn);
				break;
			}
		}
	}
}
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuggestionsPage extends MainPage {
	@FindBy(css = ".trip-card__city")
	private List<WebElement> suggestionsList;
	@FindBy(css = ".trips-search-list a:nth-child(20)")
	private WebElement tripCardName;
	@FindBy(css = ".empty-state__message")
	private WebElement oopsMsg;

	public SuggestionsPage(WebDriver driver) {
		super(driver);

	}

	public void chooseOneSuggestion(String name) {
		// waiting(6000);
		waitUntilElementToBeVisible(tripCardName);
		for (WebElement suggestion : suggestionsList) {
			System.out.println(suggestion.getText());
			if (getText(suggestion).equalsIgnoreCase(name)) {
				click(suggestion);
				break;
			}
		}
	}
	public String getOopsMsg() {
		waitUntilElementToBeClickable(oopsMsg);
		return getText(oopsMsg);
	}
}

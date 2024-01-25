package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

	// main
	@FindBy(css = ".nav-right__user>.btn")
	private WebElement signInBtn;
	@FindBy(css = ".btn-secondary")
	private WebElement closeFirstCookies;
	@FindBy(css = "[alt='Close']")
	private WebElement closePopUpBtn;

	// chenge langauge
	@FindBy(css = ".nav-right__toggle")
	private WebElement globeBtn;
	@FindBy(css = "button.locale-settings-list__item span")
	private List<WebElement> langaugeList;

	// chenge currency
	@FindBy(css = "button:nth-child(2) > div.locale-settings__tab-title")
	private WebElement currencyBtn;
	@FindBy(css = "button.locale-settings-list__item ")
	private List<WebElement> currencyList;

	// login
	@FindBy(css = ".sign-in-form__signup-button>a>span")
	private WebElement signupBtn;
	@FindBy(css = ".sign-up-form__login-button>span")
	private WebElement backToLoginBtn;

	// build you own trip Btn
	@FindBy(css = ".btn-blue-outlined.btn.btn-link")
	private WebElement buildYourTripBtn;
	@FindBy(css = "#__next div.footer__top > div:nth-child(2) li:nth-child(5) > a")
	private WebElement carRentalBtn;

	// DestinationsBtn
	@FindBy(css = ".home-destinations .home-list-header__title")
	private WebElement Destinations;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/nav[1]/div[1]/a[1]")
	private WebElement destinationsBtn;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void moveToLogin() {
		click(signInBtn);
	}

	public void moveToSignup() {
		click(signupBtn);
	}

	public void backToLogin() {
		click(backToLoginBtn);
	}

	public void buildYourOwnTrip() {
		click(buildYourTripBtn);
	}

	public void makePopUpOpen() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
	}

	public void closePopUp() {
		try {
			waitUntilElementToBeClickable(closePopUpBtn);
			click(closePopUpBtn);
		} catch (Exception e) {
		}
	}

	public void closeCookies() {
		try {
			waitUntilElementToBeClickable(closeFirstCookies);
			click(closeFirstCookies);
		} catch (Exception e) {
		}
	}

	public void scrollDown() {
		act.scrollToElement(carRentalBtn);
		click(carRentalBtn);
	}

	public void scrollToCarRentalSlowly() {
		for (int i = 0; i < 10; i++) {
			((JavascriptExecutor) driver).executeScript(("window.scrollBy(0, 200)"));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", carRentalBtn);
		click(carRentalBtn);
	}

	public void moveToDestinations() {
		click(destinationsBtn);
	}

	public void hoverOverGlobeBtn() {
		waitUntilElementToBeClickable(globeBtn);
		act.moveToElement(globeBtn);
		act.build().perform();
	}

	public void chooseLanguage(String langaugeName) {
		for (WebElement language : langaugeList) {
			if (getText(language).equalsIgnoreCase(langaugeName)) {
				click(language);
				break;
			}
		}
	}

	public void chooseCurrency(String currencyName) {
		hoverOverGlobeBtn();
		click(currencyBtn);
		for (WebElement currency : currencyList) {
			if (getText(currency).toLowerCase().contains(currencyName)) {
				click(currency);
				break;
			}
		}
	}
	public void moveToNewPage() {
		ArrayList<String> carWindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(carWindow.get(1));
	}
}

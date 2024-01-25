package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectCarPage extends MainPage {

	@FindBy(css = ".car_group_wrapper .carType-container .checkbox [for*='car_group']")
	private List<WebElement> carTypeArea;
	@FindBy(css = ".col-xs-12.col-sm-12.col-md-3 .carType-container-desktop > div:nth-child(2)  label")
	private WebElement title;

	@FindBy(css = "#chooseCar29D10")
	private WebElement bookCarBtn;

	public SelectCarPage(WebDriver driver) {
		super(driver);
	}

	public void waitForTheNewPage() {
		waitUntilElementToBeClickable(title);
		getText(title);
	}

	public void changeCarType(String carType) {
		for (WebElement cType : carTypeArea) {
			if (cType.getText().equalsIgnoreCase(carType)) {
				click(cType);
				break;
			}
		}
	}

	public void changeCarTypes(String carType, String carType1, String carType2, String carType3) {
		changeCarType(carType);
		changeCarType(carType1);
		changeCarType(carType1);
		changeCarType(carType2);
		changeCarType(carType2);
		changeCarType(carType3);
	}

	// choose premium car group
	public void bookCar() {
		waitUntilElementToBeClickable(bookCarBtn);
		click(bookCarBtn);
	}
}

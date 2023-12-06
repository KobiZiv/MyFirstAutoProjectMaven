package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectCarPage extends MainPage{

	@FindBy(css = ".col-xs-12.col-sm-12.col-md-3 .carType-container .car_group_check .checkbox > label")
	private List<WebElement> carTypeArea;
	@FindBy(css = ".col-xs-12.col-sm-12.col-md-3 .carType-container-desktop > div:nth-child(2)  label")
	private WebElement title;
	
	@FindBy (css="#chooseCar29D10")
	private WebElement bookCarBtn;
	public SelectCarPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void waitForTheNewPage() {
		waitUntilElementToBeClickable(title);
		getText(title);
	}
	
	public void changeCarType (String carType) {
		for (WebElement cType : carTypeArea) {
			if (cType.getText().equalsIgnoreCase(carType)) {
				click(cType);
				break;
			}
		}
	}
	//choose premium car group
	public void bookCar() {
		waitUntilElementToBeClickable(bookCarBtn);
		click(bookCarBtn);
	}
}

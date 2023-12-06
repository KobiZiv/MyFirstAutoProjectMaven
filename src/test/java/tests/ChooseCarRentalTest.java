package tests;

import java.sql.Driver;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CarRentalPage;
import pages.DestinationsPage;
import pages.ExploreDestinationPage;
import pages.ExtrasAndUpgrades;
import pages.MainPage;
import pages.SelectCarPage;
import pages.LaTourEiffelPage;

public class ChooseCarRentalTest extends BaseTest {

	@Test
	public void tc_01ChooseCarRental() {
		MainPage mp = new MainPage(driver);
		mp.closeCookies();
		mp.hoverOverGlobeBtn();
		mp.chooseLanguage("Hebrew");
		waiting(600);
		mp.hoverOverGlobeBtn();
		mp.chooseLanguage("English");
		mp.closePopUp();
		mp.scrollToCarRentalSlowly();
		ArrayList<String> carWindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(carWindow.get(1));
		CarRentalPage crp = new CarRentalPage(driver);
		crp.chooseCountryName("Ireland");
		crp.choosePickUpLocation("Dublin Airport");
		crp.selectPickUpDate("10", "January 2024");
		crp.choosePickUpTime("11:00");
		crp.chooseDropOffLocation("Dublin Airport");
		crp.chooseDropOffTime("14:00");
		crp.setDriverAge("44");
		crp.selectReturnDate("17", "January 2024");
		crp.SelectCarType("Small");
		crp.searchForCars();
		SelectCarPage scp = new SelectCarPage(driver);
		scp.waitForTheNewPage();
		waiting(2000);
		scp.changeCarType("Small");
		scp.changeCarType("Medium");
		waiting(2000);
		scp.changeCarType("Medium");
		scp.changeCarType("Large");
		waiting(2000);
		scp.changeCarType("Large");
		scp.changeCarType("Premium");
		scp.bookCar();
		ExtrasAndUpgrades eau = new ExtrasAndUpgrades(driver);
		String expected = "Bmw 3";
		String actual = eau.getSelectedCarName();
		Assert.assertEquals(actual, expected);
	}

//	@Test
//	public void tc_03SelectCurrency() {
//		MainPage mp = new MainPage(driver);
//		mp.closeCookies();
//		mp.hoverOverGlobeBtn();
//		mp.chooseCurrency("euro");
//	}
}

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

public class ChooseDestinationTest extends BaseTest {

	@Test
	public void tc_01ChooseDestination() {
		MainPage mp = new MainPage(driver);
		mp.closeCookies();
		mp.moveToDestinations();
		DestinationsPage dp = new DestinationsPage(driver);
		dp.searchDestinations("Paris");
		dp.closePopUp();
		dp.scrollToDestination();
		dp.findDestinationName("paris, france");
		ExploreDestinationPage edp = new ExploreDestinationPage(driver);
		edp.moveToOption("top places");
		edp.choosePlace("la tour eiffel");
		ArrayList<String> eiffelTourWindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(eiffelTourWindow.get(1));
		LaTourEiffelPage ltep = new LaTourEiffelPage(driver);
		Assert.assertTrue(ltep.isLaTourEiffel());
	}

}
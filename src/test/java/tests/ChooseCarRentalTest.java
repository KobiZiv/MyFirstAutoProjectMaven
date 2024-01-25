package tests;

//import java.sql.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChooseCarRentalTest extends AppBaseTest {

	@Test
	public void tc_01ChooseCarRental() {
		mainPage.closePopUp();
		mainPage.closeCookies();
		mainPage.hoverOverGlobeBtn();
		mainPage.chooseLanguage("Hebrew");
		waiting(600);
		mainPage.hoverOverGlobeBtn();
		mainPage.chooseLanguage("English");
		mainPage.scrollToCarRentalSlowly();
		mainPage.moveToNewPage();
		carRentalPage.selectPickUpDate("11", "March 2024");
		carRentalPage.selectReturnDate("18", "March 2024");
		carRentalPage.carRentalInfo("Ireland", "Dublin Airport", "11:00", "Medium", "Dublin Airport", "14:00","44");
		selectCarPage.waitForTheNewPage();
		selectCarPage.changeCarTypes("Medium", "Large","Station Wagon", "Premium");
		selectCarPage.bookCar();
		String expected = "Bmw 3";
		String actual = extrasAndUpgrades.getSelectedCarName();
		Assert.assertEquals(actual, expected);
	}

}

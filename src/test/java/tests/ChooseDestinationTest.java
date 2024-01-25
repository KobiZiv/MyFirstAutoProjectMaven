package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChooseDestinationTest extends AppBaseTest {

	@Test
	public void tc_01ChooseDestination() {
		mainPage.closeCookies();
		mainPage.moveToDestinations();
		destinationsPage.searchDestinations("Paris");
		destinationsPage.closePopUp();
		destinationsPage.scrollToDestination();
		destinationsPage.findDestinationName("paris, france");
		exploreDestinationPage.moveToOption("top places");
		exploreDestinationPage.choosePlace("la tour eiffel");
		exploreDestinationPage.moveToNewPage();
		Assert.assertTrue(laTourEiffelPage.isEiffelTower());
	}
}
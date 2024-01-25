package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TripPurposeTest extends AppBaseTest {
	@Test
	public void tc_01ChooseTripPurpose() {
		mainPage.closeCookies();
		mainPage.buildYourOwnTrip();
		mainPage.closePopUp();
		basicsPage.inspireMe();
		journeyDatesPage.setFlexDates();
		try {
			tripPurposePage.chooseTripPurpose("ספורט");
		} catch (Exception e) {

		}
		try {
			tripPurposePage.chooseTripPurpose("Sport");
		} catch (Exception e) {

		}
		interestsPage.rateInterest(8, 4, 6, 2, 3, 7, 5, 6);
		interestsPage.showResults();
		suggestionsPage.chooseOneSuggestion("Barcelona");
		String expected = "Your personalized trip to Barcelona";
		String actual = destinationsPage.getOopsMsg();
		Assert.assertEquals(actual, expected);
	}
}

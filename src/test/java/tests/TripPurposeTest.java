package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasicsPage;
import pages.DestinationsPage;
import pages.InterestsPage;
import pages.JourneyDatesPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SuggestionsPage;
import pages.TripPurposePage;

public class TripPurposeTest extends BaseTest{
	@Test
	public void tc_01ChooseTripPurpose() {
		MainPage mp = new MainPage(driver);
		mp.closeCookies();
//		mp.hoverOverGlobeBtn();
//		mp.chooseLanguage("Hebrew");
//		waiting(600);
//		mp.hoverOverGlobeBtn();
//		mp.chooseLanguage("English");
		mp.buildYourOwnTrip();
		mp.closePopUp();
		BasicsPage bp = new BasicsPage(driver);
		bp.inspireMe();
		JourneyDatesPage jdp = new JourneyDatesPage(driver);
		jdp.setFlexDates();
		TripPurposePage tpp = new TripPurposePage(driver);
		try {
			tpp.chooseTripPurpose("ספורט");
		} catch (Exception e) {

		}
		try {
			tpp.chooseTripPurpose("Sport");
		} catch (Exception e) {

		}					
		InterestsPage ip = new InterestsPage(driver);
		ip.rateInterest(8,4,6,2,3,7,5,6);
		ip.showResults();
		SuggestionsPage sp = new SuggestionsPage(driver);
		sp.chooseOneSuggestion("Barcelona");
		DestinationsPage dp = new DestinationsPage(driver);
		String expected = "Your personalized trip to Barcelona";
		String actual = dp.getOopsMsg();
		Assert.assertEquals(actual, expected);
	}

}

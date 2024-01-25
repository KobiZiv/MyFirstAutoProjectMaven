package tests;

import org.testng.annotations.BeforeClass;

import pages.BasicsPage;
import pages.CarRentalPage;
import pages.DestinationsPage;
import pages.ExploreDestinationPage;
import pages.ExtrasAndUpgrades;
import pages.InterestsPage;
import pages.JourneyDatesPage;
import pages.LaTourEiffelPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SelectCarPage;
import pages.SignupPage;
import pages.SuggestionsPage;
import pages.TripPurposePage;

public class AppBaseTest extends BaseTest{
	
	MainPage mainPage;
	CarRentalPage carRentalPage;
	SelectCarPage selectCarPage;
	ExtrasAndUpgrades extrasAndUpgrades;
	DestinationsPage destinationsPage ;
	ExploreDestinationPage exploreDestinationPage;
	LaTourEiffelPage laTourEiffelPage;
	LoginPage loginPage;
	SignupPage signupPage;
	BasicsPage basicsPage;
	JourneyDatesPage journeyDatesPage;
	TripPurposePage tripPurposePage;
	InterestsPage interestsPage;
	SuggestionsPage suggestionsPage;
	

	@BeforeClass
	public void appBaseTest () {	
		mainPage = new MainPage(driver);
		carRentalPage = new CarRentalPage(driver);
		selectCarPage = new SelectCarPage(driver);
		extrasAndUpgrades = new ExtrasAndUpgrades(driver);
		destinationsPage = new DestinationsPage(driver);
		exploreDestinationPage = new ExploreDestinationPage(driver);
		laTourEiffelPage = new LaTourEiffelPage(driver);
		loginPage = new LoginPage(driver);
		signupPage = new SignupPage(driver);
		basicsPage = new BasicsPage(driver);
		journeyDatesPage = new JourneyDatesPage(driver);
		tripPurposePage = new TripPurposePage(driver);
		interestsPage = new InterestsPage(driver);
		suggestionsPage = new SuggestionsPage(driver);

	}	
}

package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

import googleSearch.Home;
import googleSearch.Results;

public class NewTest_POM {
	private WebDriver driver;
	private Home homePage;
	private Results resultsPage;

	@Test
	public void assertGoogleLogoIsDisplayed() {
		System.out.println("Check to see if google logo is displayed...");
		Assert.assertTrue(homePage.isGoogleLogoDisplayed());
	}

	@Test
	public void assertGooglePageTitleIsCorrect() {
		System.out.println("Check to see if google home page has the correct title...");

		Assert.assertEquals(homePage.getCurrentPageTitle(), homePage.getPageTitle());
	}

	@Test
	public void searchForSeleniumAndAssertResultStatsIsNotEmpty() {
		homePage.searchForQuery("Selenium");
		Assertions.assertElementAttribute(driver, resultsPage.getResultStats(), "text", "", AssertionComparisonType.EQUALS, AssertionType.NEGATIVE);
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.navigateToURL();
	}

	@BeforeClass
	public void beforeClass() {
		driver = BrowserFactory.getBrowser();
		System.out.println("Successfully opened chrome browser...");
		homePage = new Home(driver);
		resultsPage = new Results(driver);
		System.out.println("Successfully initialized page objects...");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("Closed all open browser windows...");
	}

}

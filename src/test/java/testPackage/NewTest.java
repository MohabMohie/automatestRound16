package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;

	@Test
	public void assertGoogleLogoIsDisplayed() {
		By googleLogo_image = By.xpath("//img[@alt='Google']");
		boolean isGoogleLogoDisplayed = driver.findElement(googleLogo_image).isDisplayed();
		Assert.assertTrue(isGoogleLogoDisplayed);
	}

	@Test
	public void assertGooglePageTitleIsCorrect() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Google");
	}

	@Test
	public void searchForSeleniumAndAssertResultStatsIsNotEmpty() {
		By googleSearchBox_input = By.xpath("//input[@title='Search']");
		driver.findElement(googleSearchBox_input).sendKeys("Selenium" + Keys.ENTER);

		By resultStats_label = By.id("result-stats");
		String resultStats = driver.findElement(resultStats_label).getText();
		Assert.assertNotEquals(resultStats, "");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to("https://www.google.com/ncr");
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

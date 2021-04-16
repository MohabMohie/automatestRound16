package googleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Home {
	// variables
	private String url = "https://www.google.com/ncr";
	private String pageTitle = "Google";

	// driver and locators
	private WebDriver driver;
	private By googleLogo_image = By.xpath("//img[@alt='Google']");
	private By googleSearchBox_input = By.xpath("//input[@title='Search']");

	// Constructor
	public Home(WebDriver driver) {
		this.driver = driver;
	}

	// Keywords / Actions
	public void navigateToURL() {
		driver.navigate().to(url);
		System.out.println("Successfully navigated to ["+url+"] ...");

	}

	public boolean isGoogleLogoDisplayed() {
		System.out.println("Checking to see if google logo is displayed...");
		return driver.findElement(googleLogo_image).isDisplayed();
	}

	public String getCurrentPageTitle() {
		System.out.println("Getting current page title...");
		return driver.getTitle();
	}

	public String getPageTitle() {
		System.out.println("Getting expected Google Home page title...");
		return pageTitle;
	}
	
	public void searchForQuery(String searchQuery) {
		System.out.println("Searching for ["+searchQuery+"]...");
		driver.findElement(googleSearchBox_input).sendKeys(searchQuery + Keys.ENTER);
	}
}
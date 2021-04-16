package googleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
	// variables

	private By resultStats_label = By.id("result-stats");

	// Constructor
	public Results(WebDriver driver) {
	}

	// Keywords / Actions
	public By getResultStats() {
		System.out.println("Getting result stats text...");
		return resultStats_label;
	}
}

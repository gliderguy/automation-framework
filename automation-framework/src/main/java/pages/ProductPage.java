package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Page {

	By title	= By.className("prodtitle");

	public ProductPage(WebDriver webDriver) {
		super(webDriver);
	}

	public String getTitle(){
		return webDriver.findElement(title).getText();
	}
}

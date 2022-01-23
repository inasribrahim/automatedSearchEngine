package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchEnginePage {

	public WebDriver driver;
	By searchBox = By.name("q");
	By suggestSearchBox = By.cssSelector(".eIPGRd");
	By searchBtn = By.cssSelector(".gNO89b");

	public SearchEnginePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}

	public List<WebElement> getSuggestSearchBox() {
		return  driver.findElements(suggestSearchBox);

	}
	public WebElement getsearchBtn()
	{
		return driver.findElements(searchBtn).get(0);
	}

}

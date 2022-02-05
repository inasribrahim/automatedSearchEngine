package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LandingPage {

	
	public WebDriver driver;
	
	By searchBox = By.name("q");
	By resultDescription= By.xpath("//div[@class='VwiC3b yXK7lf MUxGbd yDYNvb lyLwlc lEBKkf']/span");
	By title = By.tagName("h3");

	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getsearchBox()
	{
		return driver.findElement(searchBox);
	}
	public List<WebElement> getTitles()
	{
		return driver.findElements(title);
	}
	
	public List<WebElement> getResultDescription() {
		return driver.findElements(resultDescription);
	}
	

	
}

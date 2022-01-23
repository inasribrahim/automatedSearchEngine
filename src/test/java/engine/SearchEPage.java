package engine;

import java.io.IOException;

import org.junit.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.SearchEnginePage;
import resources.base;

public class SearchEPage extends base {
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
	}
	@Test 
	public void clickOnSuggestWord(String suggestedQuery) throws IOException, InterruptedException {
		SearchEnginePage s = new SearchEnginePage(driver);
		Thread.sleep(3000L);
		int size = s.getSuggestSearchBox().size();
		for (int i = 0; i < size; i++) {
			if (s.getSuggestSearchBox().get(i).getText().equals(suggestedQuery)) {
				s.getSuggestSearchBox().get(i).click();
				break;
			}
		}
		
	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;

	}

}

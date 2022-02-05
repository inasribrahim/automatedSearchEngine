package engine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateSearchEngineAPIToUI extends base {
	boolean flag = false;
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test

	public void validateApiToUi(String query) throws IOException {
		LandingPage p = new LandingPage(driver);
		CreateRequest req = new CreateRequest(); 
		String getFirstTitleAPI = req.getFirstTitleApi(query);
		int size = p.getTitles().size();
		for(int i =0 ;i <size ;i++) {

			if(p.getTitles().get(i).getText().equals(getFirstTitleAPI)) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);   
		System.out.println("Validate  title from (UI to API) : Test completed");
	}
	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;

	}
}

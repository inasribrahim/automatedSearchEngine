package engine;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import resources.base;

public class ValidateSearchSummary extends base {
	boolean flag = false;

	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test

	public void validateBadResult(String query) throws IOException {
		// assume that the user enter a misspelling query
		LandingPage l = new LandingPage(driver);
		// Loop in 3 result summary  to assert the query search related to result summary 
		for (int i = 0; i < 3; i++) {
			String des = l.getResultDescription().get(i).getText();
			if (des.toLowerCase().contains(query)) {
				flag = true; 
			}
		}
		Assert.assertFalse(flag); // assume that the user enter a misspelling query  
	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;

	}

}

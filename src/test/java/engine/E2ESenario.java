package engine;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class E2ESenario extends base {
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test

	public void applicableLink(String link) throws IOException {
		LandingPage l = new LandingPage(driver);
		int numberOfSearchResult = 8;
		for (int i = 0; i < numberOfSearchResult; i++) {
			if (link.contentEquals(l.getTitles().get(i).getText())) {
				l.getTitles().get(i).click();
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

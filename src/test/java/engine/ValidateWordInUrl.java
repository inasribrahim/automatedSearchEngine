package engine;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateWordInUrl extends base {
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@Test
	
	public void validateUrl() throws IOException
	{
		String strUrl = driver.getCurrentUrl();
		String result = java.net.URLDecoder.decode(strUrl, StandardCharsets.UTF_8.name()); // Url is encode for utf-8 
		String urlResultSearch = result.split("q=")[1].split("&")[0].replaceAll("[+]*", "");
		LandingPage l =new LandingPage(driver);
		String inputSearch = l.getsearchBox().getAttribute("value");
		Assert.assertEquals(inputSearch, urlResultSearch);
		System.out.println("validate word in url : Test completed");

	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;	
	}

}

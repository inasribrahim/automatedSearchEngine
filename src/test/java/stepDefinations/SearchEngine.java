package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import engine.SearchEPage;
import engine.ValidateSearchEngineAPIToUI;
import engine.ValidateSearchSummary;
import engine.E2ESenario;
import engine.ValidateWordInUrl;
import pageObjects.LandingPage;
import pageObjects.SearchEnginePage;
import resources.base;

public class SearchEngine extends base {

	@Given("^that I have gone to \"([^\"]*)\" page with chrome browser$")
	public void that_i_have_gone_to_something_page_with_chrome_browser(String strArg1) throws Throwable {
		driver = initializeDriver();
		driver.get(strArg1);
		driver.manage().window().maximize();
	}

	@When("^I fill (.+) to the search box$")
	public void i_fill_to_the_search_box(String query) throws Throwable {
		LandingPage l = new LandingPage(driver);
		l.getsearchBox().sendKeys(query);
	}

	@And("^Click on suggest (.+) word$")
	public void click_on_suggest_word(String suggest) throws Throwable {
		SearchEPage s = new SearchEPage();
		s.clickOnSuggestWord(suggest);
	}

	@When("^Click the Search Button$")
	public void click_the_Search_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		SearchEnginePage s = new SearchEnginePage(driver);
		s.getsearchBtn().click();
	}

	@Then("^The \"([^\"]*)\" should be mentioned in the results$")
	public void the_should_be_mentioned_in_the_results(String arg1) throws Throwable {
		ValidateWordInUrl obj2 = new ValidateWordInUrl();
		ValidateSearchEngineAPIToUI obj = new ValidateSearchEngineAPIToUI();
		obj2.validateUrl();		
		obj.validateApiToUi(arg1);
	}

	@Then("^The \"([^\"]*)\" should not be mentioned in the results$")
	public void the_should_not_be_mentioned_in_the_results(String arg1) throws Throwable {
		ValidateSearchSummary obj = new ValidateSearchSummary();
		obj.validateBadResult(arg1);
	}

	@And("^click the link (.+)$")
	public void click_the_link(String link) throws Throwable {
		E2ESenario e = new E2ESenario();
		e.applicableLink(link);
	}

	@Then("^close browsers$")
	public void close_browsers() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

}

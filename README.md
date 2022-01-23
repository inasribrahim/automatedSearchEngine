# automatedSearchEngine
Cucumber Google Search using Selenium and Rest Assured
[![LinkedIn](linkedin-shield)](https://www.linkedin.com/in/ibrahim-nasr-001b60202/)

## How to run project:
- Run testngCucumber.xml file

## Feature File  
## Scenarios
- Happy Scenario
- Negative Scenario
- E2E Scenario

## Report
![alt text](https://github.com/inasribrahim/automatedSearchEngine/blob/master/ReportFile2022-23-1.JPG)

## How to make google custom engine to use paraemter in rest assured
-  Create a project on Google Developers Console
https://console.developers.google.com
-  Enable Custom Search API and generate API key
-   Create a search engine
https://cse.google.com/cse/all


## Dependencies in POM.xml
| Dependencies  | Version |
| ------ | ------ |
| Selenium | 3.4.0 |
| TestNG |  6.8 |
| rest-assured |4.3.1 | 
| json-path |4.3.1 | 
| webdrivermanage | 5.0.3 |
| cucumber-core |1.2.5 |
| cucumber-java |1.2.5 |
|cucumber-jvm-deps|1.0.5|
|gherkin|2.12.2|
## Asseration : Verifying first result from api request in titles to  selenium-ui 
- Create request and get parameter from property file [ api_key  - q(query) - cx(Unique for custom-engine ) - number(Number of results) - HOST( endpoint of google api custom engine ) - Cookie (Cookie cahced from google account) ]
- Make a request and  send query parameter and header (must) and add resource endpoint - "/customsearch/v1" 
- Assert status code is 200  and Content Type:json to ensure reponse vaild from google search result  
- Extract reponse to get title from reponse using help method ( RawData.rawToJson ) to ensure data get correctly
- return first title from response to use in search engine (steps)
## How make request using custom engine google api after created google custom engine
-  query parameter key : api key 
-  query parameter cx : unique id project after (after create project in google and using serivce custom engine and get cx)
-  query parameter q  : query serach 
-  query parameter number : The Number of search results 
https://www.googleapis.com/customsearch/v1?key={{searchKey}}&cx={{seanrchEngineId}}&q=python download&num=5
## Create Request and get frist title
```JAVA
	public class CreateRequest {
	@Test
	public  String getFirstTitleApi(String query) {
		base b  = new base();
		List<String> result = b.getDataFromFile();
        String host = result.get(4);
	RestAssured.baseURI= host;
// 1 >> api_key & 2 >> input Search static & 
// 3 >> Number result & 4 >> host name of google api & 5 >> Cookies cached from google account 
	Response res=
			given().
			header("Content-Type", "application/json").
			cookie("Cookies",result.get(5)).
			queryParam("key",result.get(0) ).
            queryParam("cx", result.get(1)).
            queryParam("q", query).
            queryParam("num", result.get(3)).
	when().
	get(resources.resourceGoogleEngine()).
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
	extract().response();
	
	JsonPath js= RawData.rawToJson(res);
	String firstResultInSearch = js.get("items[0].title");
	return firstResultInSearch;
	}}
```
## Validate Search Engine API to UI
-  Get return value from create request class - frist title of page 
-  Get titles from  selenium-ui 
-  Loop in titles and assert the value is the equal from UI to API
```JAVA
	@Test
	public void validateApiToUi(String query) throws IOException {
		boolean flag = false;
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
		//System.out.println("Validate  title from (UI to API) : Test completed");
	}
```
## Asseration : Verifying that the user entered misspelling query 
- Loop in 3 desciptions result
- Check item enterd in saerch box field not realted to description 

```JAVA
@Test
	public void validateBadResult(String query) throws IOException {
		// assume that the user enter a misspelling query
		LandingPage l = new LandingPage(driver);
		// Loop in 3 result summary  to assert the query search related to result summary 
		for (int i = 0; i < 3; i++) {
			String des = l.getResultDescription().get(i).getText();
			if (des.toLowerCase().contains(query)) {
				flag = true; }}
		Assert.assertFalse(flag); // assume that the user enter a misspelling query  
	}
```
## Asseration - Verifying the displayed item in uri entered from user   
- Decode url because it is encoding UTF-8, if the search arabic it display ?? ??? ? ? ?? 
- Extract Url using split build-in method
example search for vidscola and seen the url( https://www.google.com/search?q=vidscola&sxsrf=AOaemvJBAlGjJsvXgnvd8Wm8Jwe_ClILOw%3A1642844773079&ei=ZdLrYbSpBMnKgweHvpX4DA&gs_ssp=eJzj4tVP1zc0TDe0NLHMKjA1YLRSNagwNDG1MDFMNLUwSzFOSbVIsjKoME0EKkhKTko1SzFJSzMy8OIoy0wpTs7PSQQAJIwSRg&oq=vid&gs_lcp=Cgdnd3Mtd2l6EAMYADIKCC4QxwEQrwEQJzIECCMQJzIECCMQJzIICAAQsQMQkQIyBQgAEJECMggIABCABBCxAzIICAAQgAQQsQMyCAgAEIAEELEDMgUIABCABDIFCAAQgAQ6BAgAEEc6DgguEIAEELEDEMcBEKMCOggILhCABBCxAzoLCC4QsQMQxwEQ0QM6CwguELEDEMcBEK8BOgUIABCxA0oECEEYAEoECEYYAFCExQdYy8gHYKjQB2gAcAZ4AIABrQGIAf4DkgEDMC4zmAEAoAEByAEIwAEB&sclient=gws-wiz)
- I split using (q) and get second index value and split again using (&) and get first index array and replace all + to blank to remove  + from link if the link related to arabic search  
- Check item enterd in saerch box field realted to description and if not realted change the flag to false 
- Assert the result from item entered into search box to extracted value from url 
```JAVA
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
```
## Reference 
https://developers.google.com/custom-search/v1/overview

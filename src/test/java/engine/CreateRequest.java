package engine;

import static io.restassured.RestAssured.given;
import resources.base;
import java.util.List;

import org.testng.annotations.Test;

import resources.RawData;
import resources.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

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
	}
	
	
}

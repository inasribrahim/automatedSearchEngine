package resources;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RawData {
	
	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		return x;
	}
}

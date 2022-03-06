package APIGroup.Projec2;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Hello world!
 *
 */
 class Testing{
public void postmap() throws IOException
{
	

	RestAssured.baseURI= "https://rahulshettyacademy.com";
	Map <String,String> mp = new HashMap<String,String>();
	mp.put("Content-Type", "application/json");
	mp.put("Connection", "keep-alive");
	Response res =	given().log().all().relaxedHTTPSValidation().queryParam("key", "qaclick123").headers(mp).body("Riyaz").
			when().post("maps/api/place/add/json").
			then().extract().response().prettyPeek();


	int status=	res.statusCode();
	if (status>=200&&status<=226) {

		System.out.println("This is the response "+res.asString());

		System.out.println("The status of the code is " +status);
		JSONObject js = new JSONObject(res.asString());
		
		
	}
	else
	{
		System.out.println("Unfortunately the the request was throwing "+status+" Code please check from the your end or contact service adminstrator");
	}
}
}
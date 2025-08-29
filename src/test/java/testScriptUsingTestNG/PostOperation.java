package testScriptUsingTestNG;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibraries.AutoConstant;
import genericLibraries.DataUtilities;
import genericLibraries.POJOClass;
import io.restassured.http.ContentType;

public class PostOperation extends BaseClass{
	
	@Test
	public void postOperation() throws IOException {
		
//		JSONObject jobj = new JSONObject();
//		jobj.put("name", "RestAssuredFrameworkCreateRepo");
//		jobj.put("Description", "Created Repo using RestAssured Framework");
		
		DataUtilities dataUtilities = new DataUtilities();
		POJOClass pojoClass = new POJOClass(dataUtilities.readData("pojoRepo"),dataUtilities.readData("pojoDescription"));
		
		
		given()
			.contentType(ContentType.JSON)
//			.body(jobj)
			.body(pojoClass)
			.auth().oauth2(dataUtilities.readData("auth"))
		.when()
			.post(AutoConstant.postOperation)
		.then()
			.statusCode(201).log().all();
		
	}

}

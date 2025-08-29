package testScriptUsingTestNG;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibraries.AutoConstant;
import genericLibraries.DataUtilities;
import genericLibraries.POJOClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class PatchOperation  extends BaseClass{
	
	@Test
	public void patchOperation() throws IOException{
		
//		JSONObject jobj = new JSONObject();
//		jobj.put("name", "RestAssuredFrameworkUpdateRepo");
		
		DataUtilities dataUtilities = new DataUtilities();
		POJOClass pojoClass = new POJOClass(dataUtilities.readData("pojoUpdateRepo"),dataUtilities.readData("pojoUpdateDescription"));
		
		given()
			.contentType(ContentType.JSON)
//			.body(jobj)
			.body(pojoClass)
			.pathParam("owner", dataUtilities.readData("owner"))
			.pathParam("repo", dataUtilities.readData("pojoRepo"))
			.auth().oauth2(dataUtilities.readData("auth"))
		.when()
			.patch(AutoConstant.patchOperation)
		.then()
			.statusCode(200).log().all();
			
	}

}

package testScriptUsingTestNG;

import org.testng.annotations.Test;

import genericLibraries.AutoConstant;
import genericLibraries.DataUtilities;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class GetOperation extends BaseClass {
	
	
	@Test
	public void getOperation() throws IOException {
		given()
			.pathParam("owner", dataUtilities.readData("owner"))
			.pathParam("repo", dataUtilities.readData("repo"))
		.when()
			.get(AutoConstant.getOperation)
		.then()
			.statusCode(200).log().all();
		
	}

}

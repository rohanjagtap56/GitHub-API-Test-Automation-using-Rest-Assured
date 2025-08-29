package testScriptUsingTestNG;

import org.testng.annotations.Test;

import genericLibraries.AutoConstant;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class DeleteOperation extends BaseClass{
	
	@Test
	public void deleteOperation() throws IOException, InterruptedException {
		Thread.sleep(3000);
		given()
			.pathParam("owner", dataUtilities.readData("owner"))
			.pathParam("repo", dataUtilities.readData("pojoUpdateRepo"))
			.auth().oauth2(dataUtilities.readData("auth"))
		.when()
			.delete(AutoConstant.deleteOperation)
		.then()
			.statusCode(204).log().all();
	}

}

package StepDefinition;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import genericLibraries.AutoConstant;
import genericLibraries.DataUtilities;
import genericLibraries.POJOClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiGithubCRUDUsingCucumberStepDefinition {
	
	DataUtilities dataUtilities = new DataUtilities();
	RequestSpecification request;
	Response response;
	

	@When("Set POST request HEADER and body parameter")
	public void set_post_request_header_and_body_parameter() throws IOException {
		POJOClass pojoClass = new POJOClass(dataUtilities.readData("BddRepo"),dataUtilities.readData("BddDescription"));
		request = given()
			.contentType(ContentType.JSON)
			.body(pojoClass)
			.auth().oauth2(dataUtilities.readData("auth"));
		
	}

	@When("Send POST HTTP request")
	public void send_post_http_request() {
		response = request.when().post(AutoConstant.postOperation);
	}

	@When("Set Get Request HEADER")
	public void set_get_request_header() throws IOException {
		request = given()
		.pathParam("owner", dataUtilities.readData("owner"))
		.pathParam("repo", dataUtilities.readData("BddRepo"));
	}

	@When("Send GET HTTP request")
	public void send_get_http_request() {
		response = request.when()
		.get(AutoConstant.getOperation);
	}

	@When("Set Patch request HEADER and body parameter")
	public void set_patch_request_header_and_body_parameter() throws IOException {
			POJOClass pojoClass = new POJOClass(dataUtilities.readData("BddUpdateRepo"),dataUtilities.readData("BddUpdateDescription"));
		
		request = given()
			.contentType(ContentType.JSON)
			.body(pojoClass)
			.pathParam("owner", dataUtilities.readData("owner"))
			.pathParam("repo", dataUtilities.readData("BddRepo"))
			.auth().oauth2(dataUtilities.readData("auth"));
	}

	@When("Send Patch HTTP request")
	public void send_patch_http_request() {
	    response = request.when().patch(AutoConstant.patchOperation);
	}

	@When("Set Delete request HEADER")
	public void set_delete_request_header() throws IOException {
	    request = given()
				.pathParam("owner", dataUtilities.readData("owner"))
				.pathParam("repo", dataUtilities.readData("BddUpdateRepo"))
				.auth().oauth2(dataUtilities.readData("auth"));
	}

	@When("Send Delete HTTP request")
	public void send_delete_http_request() throws InterruptedException {
		Thread.sleep(3000);
	    response = request.when()
				.delete(AutoConstant.deleteOperation);
	}

	@Then("I receive valid HTTP Response code as {int}")
	public void i_receive_valid_http_response_code_as(Integer int1) {
		response.then()
        	.statusCode(int1).log().all();
	}

}

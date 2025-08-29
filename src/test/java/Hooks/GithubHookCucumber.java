package Hooks;

import io.cucumber.java.Before;
import static io.restassured.RestAssured.*;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;


public class GithubHookCucumber {
	
	
	@Before
	public void setBaseUrl() {
		
		baseURI = "https://api.github.com";
	}
	
	@AfterMethod
	public void tearDown() {
		Reporter.log("CRUD Operation is successful");
	}

}

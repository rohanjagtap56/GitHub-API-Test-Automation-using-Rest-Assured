package testScriptUsingTestNG;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import genericLibraries.DataUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.*;

public class BaseClass {
	
	DataUtilities dataUtilities = new DataUtilities();
	
	@Before
	public void setUp(){
		baseURI = "https://api.github.com";
	}
//	
	@After
	public void tearDown() {
		Reporter.log("CRUD Operation is successful");
	}
	
}

package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class test0 {
	
	public WebDriver driver;
	
	@Test
	public void demo() throws MalformedURLException {
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setBrowserName("chrome");
		
		// set the url of selenium grid
		String huburl = "http://10.203.141.254:4444";
		driver = new RemoteWebDriver(new URL(huburl),dcap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
		driver.close();
	}

}


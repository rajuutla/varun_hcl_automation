package com.hcl.baseframework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.After;

public class DriverUtils {
	
	public static WebDriver driver = null;
 
	public static void getDriver() {
		
		String browserType = System.getProperty("browser");
		
		if (browserType.equals("chrome"))
			driver = new ChromeDriver();
		else
			driver = new EdgeDriver();
		
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@After
	public static void  tearDown() {
		if (driver!=null)
		driver.quit();
	}
}

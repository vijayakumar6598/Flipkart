package com.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.constants.Constant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivers {
	
private static final Logger LOGGER=LogManager.getLogger(Drivers.class);

private static WebDriver driver=null;
	
	
public static void launchBrowser() {

		
		try {
			switch (Constant.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("launch browser");
				driver=new ChromeDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


public static WebDriver getDriver() {
	return driver;
}

}

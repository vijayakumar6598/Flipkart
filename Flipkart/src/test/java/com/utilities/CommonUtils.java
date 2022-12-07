package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import com.constants.Constant;
import com.drivers.Drivers;
import com.pageobjects.LoginPage;

import stepDefinitions.CommonStepDefinitions;

public class CommonUtils {
	//private static final Logger LOGGER=LogManager.getLogger(CommonUtils.class);
	private static CommonUtils instance=null;
	
	private CommonUtils() {
		
	}
    
	public static CommonUtils getInstance() {
		
		
		if(instance==null)
			instance=new CommonUtils();
		return instance;
	}
	public void loadProperties() {

		Properties properties=new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));

		} catch (IOException e) {
			e.printStackTrace();

		}
		Constant.APP_URL=properties.getProperty("APP_URL");
		Constant.BROWSER=properties.getProperty("BROWSER");
		Constant.UserName=properties.getProperty("UserName");
		Constant.Password=properties.getProperty("Password");
		Constant.CHROME_DRIVER_LOCATION=properties.getProperty("CHROME_DRIVER_LOCATION");
		
	}
      public void initElements() {
    	  PageFactory.initElements(Drivers.getDriver(), LoginPage.getInstance());
      }
      
      public void takeScreenshot() {
    	  
    	  File screenshot=((TakesScreenshot) Drivers.getDriver()).getScreenshotAs(OutputType.FILE);
    	  try {
    		  FileUtils.copyFile(screenshot, new File(CommonStepDefinitions.getScenarioName()+".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    	  
    	  
      }
      public void highlightText(WebElement element) {
    	 JavascriptExecutor executor=(JavascriptExecutor) Drivers.getDriver();
    	 executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
      }
      
//      public void selectFromDropDown(WebElement dropDown, String howTo, String value) {
//    	  Select select = new Select(dropDown);
//    	  
//    	  switch (howTo) {
//		case "index":
//			select.selectByIndex(Integer.parseInt(value);
//			
//			break;
//			case "value":
//				select.selectByValue(value);
//				break;
//			case "text":
//				select.selectByVisibleText(value);
//				break;
//				
//
//		default:
//			LOGGER.error("dropdown");
//			
//			break;
//		}
//      }

	}



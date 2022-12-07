package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.drivers.Drivers;
import com.utilities.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class LoginStepDefinition {


	private static final Logger LOGGER= LogManager.getLogger(LoginStepDefinition.class);
	

	@Given("the user enters correct crendentials and clicks login button")
	public void the_user_enters_correct_crendentials_and_clicks_login_button() {
		
	
			
		try {
			
			Drivers.getDriver().findElement(By.name("q")).sendKeys("iphone13"+Keys.ENTER);
						
			//Drivers.getDriver().findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/div[3]/a/div[1]/img")).click();
			
			
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot(); 
			Assert.fail(e.getMessage());
		
		}
	 			
	}
	    
	@Then("the user navigates to home page")
	public void the_user_navigates_to_home_page() {
	    
	}
	}
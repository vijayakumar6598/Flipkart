package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.Constant;
import com.drivers.Drivers;
import com.pageobjects.LoginPage;
import com.utilities.CommonUtils;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonStepDefinitions {
	private static String scenarioName=null;
	
	public static String getScenarioName() {
		return scenarioName;
	}
	
	private  static final Logger LOGGER=LogManager.getLogger(CommonStepDefinitions.class);
	
	@Before
	public void beforeScenario(Scenario scenario) {
		LOGGER.error("started");
		try {
			scenarioName=scenario.getName();
			LOGGER.error("hhbjhbklbjkl");

	        CommonUtils.getInstance().loadProperties();

			if(Drivers.getDriver()==null){
			Drivers.launchBrowser();
			CommonUtils.getInstance().initElements();
			login();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login() {
		Drivers.getDriver().get(Constant.APP_URL);
		
		LoginPage.getInstance().getUserName().sendKeys(Constant.UserName);
		
		LoginPage.getInstance().getPassword().sendKeys(Constant.Password);
		
		LoginPage.getInstance().getLoginButton().click();
		
	}

	
}

package web.dockerdemo.dockermodule.webtestclasses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.configurations.Constants;
import com.configurations.ExtentConfigurations;
import web.dockerdemo.dockermodule.webpageclasses.Screen;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.Utilities;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class TC1 extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	ITestResult result;
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;	public static final int datasetsLength = 1;

	public TC1() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC1.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("tc1.properties");
		reports = ExtentConfigurations.getExtentInstance(reportsPath, projectPath, Screen.projectName);
		test = reports.startTest("TC1");
	}
	
	public void setUP() throws Exception {
		String primaryInfo = Screen.primaryInfo;
		Constants.PRIMARY_INFO = primaryInfo;
		driver = launchBrowser(new JSONObject(primaryInfo).optString("browser_type"), configFileObj);
	}

	public void ScreenTest(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 1;
		Screen objScreen = PageFactory.initElements(driver, Screen.class);
		testLogHeader(test, "Verify Screen page");
String text1 = objScreen.textSPAN6503528686_295989();
		if(text1.equalsIgnoreCase(configFileObj.getProperty("6503528686"+ i + datasetScreencount))){
			printSuccessLogAndReport(test, logger,  "Validating Text is displayed as : " + configFileObj.getProperty("6503528686"+ i + datasetScreencount));
		} else {
			printFailureLogAndReport(test, logger,  "Label Text is not displayed as : " + configFileObj.getProperty("6503528686"+ i + datasetScreencount));
		}
String text2 = objScreen.textLI_295990();
		if(text2.equalsIgnoreCase(configFileObj.getProperty(""+ i + datasetScreencount))){
			printSuccessLogAndReport(test, logger,  "Validating Text is displayed as : " + configFileObj.getProperty(""+ i + datasetScreencount));
		} else {
			printFailureLogAndReport(test, logger,  "Label Text is not displayed as : " + configFileObj.getProperty(""+ i + datasetScreencount));
		}

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void screensTest() throws Exception {
		isElementDispalyed = true;
		for(int datasets = 1; datasets <= Screen.datasetsLength; datasets++) {
			if(!isElementDispalyed) return;			
			setUP();
			if(isElementDispalyed) { ScreenTest(datasets);}
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}
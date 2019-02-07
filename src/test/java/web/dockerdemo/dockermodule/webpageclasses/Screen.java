package web.dockerdemo.dockermodule.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class Screen extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":7,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"http://devrabbit.com/\",\"report_upload_url\":\"https://192.168.1.142:8080/TAF_Automation_DR/UploadReportFile\",\"project_name\":\"DockerDemo\",\"project_description\":\"desc\",\"project_id\":215,\"module_name\":\"DockerModule\",\"module_description\":\"desc\",\"sub_module_id\":0,\"module_id\":356,\"testcase_name\":\"TC1\",\"testcase_id\":428,\"testset_id\":0,\"executed_timestamp\":-949203839,\"browser_type\":\"chrome\"}";

	public static String projectName = "dockerdemo";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public Screen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//HTML/BODY[1]/SECTION[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[5]/DIV[2]/SPAN[1]")	
	private WebElement	_295989SPAN;
	public String textSPAN_295989() {
		waitForExpectedElement(driver, _295989SPAN);		
		String text = _295989SPAN.getText();
		_295989SPAN.click();
		return text;
	}

	@FindBy(how = How.XPATH, using = "//HTML/BODY[1]/HEADER[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/UL[1]/LI[2]")	
	private WebElement	_295990LI;
	public String textLI_295990() {
		waitForExpectedElement(driver, _295990LI);		
		String text = _295990LI.getText();
		_295990LI.click();
		return text;
	}

}
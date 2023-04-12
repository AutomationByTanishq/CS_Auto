package Config;

import Pages.Compliance_Login_Page;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.System.setProperty;

public class Configuration {

	public WebDriver driver;
	public Common common;
	public Compliance_Login_Page compliance_login_page;

	@BeforeMethod
	public void init() throws Exception {
		String targetBrowser = read_json("Browser");

		if(targetBrowser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/Driver/geckodriver");
			FirefoxOptions Foptions = new FirefoxOptions();
			driver = new FirefoxDriver(Foptions);
		}
		else if(targetBrowser.equalsIgnoreCase("chrome")) {
			setProperty("webdriver.chrome.driver", "src/Driver/chromedriver");
			ChromeOptions Coptions = new ChromeOptions();
			Coptions.addArguments("--disable-notifications");
			Coptions.addArguments("--start-maximized");
			driver = new ChromeDriver(Coptions);
		}
		else if (targetBrowser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "/usr/bin/msedgedriver");
			EdgeOptions Eoptions = new EdgeOptions();
			driver = new EdgeDriver(Eoptions);
		}
		else if (targetBrowser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else{
			throw new Exception("Browser is not correct");
		}
		driver.manage().window().maximize();
		common = new Common(driver);
		compliance_login_page = new Compliance_Login_Page(driver);
		URL url = new URL("https://secmark-np.azurewebsites.net/");
		driver.get(String.valueOf(url));
		common.log("Url Launched.");
		Thread.sleep(3000);
	}


	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) throws IOException {
		String testName = testResult.getName();
		Reporter.setCurrentTestResult(testResult);
		File img = new File("target" + File.separator + "surefire-reports" + File.separator + testName + ".png");
		if (testResult.getStatus() == 1) {
			common.log("PASS : " + testResult.getName() + "\n");
			testResult.getThrowable();
		}
		if (testResult.getStatus() == 2) {
			common.makeScreenshot(driver, testName);
			Reporter.log("Failed : This is failed log from reporter.log" + "<br>", true);
			FileOutputStream screenshotStream = new FileOutputStream(img);
			screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			Reporter.log("<a target='blank' href='" + testName + ".png'> <img  src='" + testName + ".png' height='250' width='500'></img> </a>" + "<br>");
		}
		driver.quit();
	}

	public String read_json(String Json_Key) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("src/test/resources/User_Creds.json");
		Object obj = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) obj;
		JSONObject user = (JSONObject) usersList.get(0);
		String Name = (String)user.get(Json_Key);
		return Name;
	}

}
package com.auction.init;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.auction.pages.auctionregistration.AbstractPage;

/**
 * Define Common Webdriver
 * 
 * @author Rahul Sharma
 */
public class Common extends AbstractPage {
	Date date = new Date();
	protected Wait<WebDriver> wait = null;

	public Common(WebDriver driver) {
		super(driver);
	}

	/**
	 * Open Mailinator
	 * 
	 * @param emailAddress
	 * @throws InterruptedException
	 */
	public void openMailinator(String emailAddress) throws InterruptedException {
		pause(3);
		String emailParsed[] = emailAddress.split("@");
		String url = "http://" + emailParsed[0] + ".mailinator.com";
		driver.get(url);
	}

	/**
	 * Accept present alert.
	 * 
	 * @return Text on alert
	 * 
	 */
	public String acceptAlert() {
		String alerttext = null;
		Alert alert = driver.switchTo().alert();
		alerttext = alert.getText();
		alert.accept();
		pause10Sec();
		return alerttext;
	}

	/**
	 * Check alert is present or not and accept it if present.
	 * 
	 * @return Text on alert if present, otherwise null
	 * 
	 */
	public String handleAlert() {
		String strAltert = null;
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			strAltert = alert.getText();
			//logPrint(strAltert);
			alert.accept();
			pause10Sec();
		}
		return strAltert;
	}

	/**
	 * Check alert is present or not.
	 * 
	 * @return True if alert present, otherwise false
	 * 
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	/**
	 * Dismiss present alert.
	 * 
	 * @return Text on alert
	 * 
	 */
	public String dismissAlert() {
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		alert.dismiss();
		return alerttext;
	}

	/**
	 * Get current date in MM/dd/yyyy format.
	 * 
	 * @return Current date in MM/dd/yyyy format
	 * @throws ParseException
	 * 
	 */
	public String currentDate() throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateformatMMddyyyy = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
		String currentdate = dateformatMMddyyyy.format(dateNow);
		return currentdate;
	}

	/**
	 * Get current time in hh:mm a format.
	 * 
	 * @return Current time in hh:mm a format
	 * @throws ParseException
	 * 
	 */
	public String currentTime() throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		String currenttime = dateFormat.format(dateNow).toString();
		return currenttime;
	}

	/**
	 * Get current time + 5 min in hh:mm a format.
	 * 
	 * @return Current time in hh:mm a format
	 * @throws ParseException
	 * 
	 */
	public String currentTimePlusSpecifiedMinustes(int minutes) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		Calendar cal = Calendar.getInstance(); // Get Calendar Instance
		cal.add(Calendar.MINUTE, minutes);
		String currenttime = dateFormat.format(cal.getTime()).toString();
		return currenttime;
	}

	/**
	 * Get tomorrow's date in MM/dd/yyyy format.
	 * 
	 * @return tomorrow's date in MM/dd/yyyy format
	 * @throws ParseException
	 * 
	 */
	public String tomorrowDate() throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateformatMMddyyyy = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
		String date_to_string = dateformatMMddyyyy.format(dateNow);
		String untildate = date_to_string;// Current Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance(); // Get Calendar Instance
		cal.setTime(dateFormat.parse(untildate));
		// Tomorrow's Date
		cal.add(Calendar.DATE, 1); // Date Increase by One
		String tomorrowdate = dateFormat.format(cal.getTime());
		return tomorrowdate;
	}

	/**
	 * Get future date in MM/dd/yyyy format as per argument.
	 * 
	 * @param days the days to get future date
	 * @return Future date in MM/dd/yyyy format after given days from current date
	 * @throws ParseException
	 * 
	 */
	public String FutureDate(int days) throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
		String date_to_string = dateformatyyyyMMdd.format(dateNow);
		String untildate = date_to_string;// Current Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance(); // Get Calendar Instance
		cal.setTime(dateFormat.parse(untildate));
		// Future Date
		cal.add(Calendar.DATE, days);
		String futuredate = dateFormat.format(cal.getTime());
		return futuredate;
	}

	/**
	 * Get past date in MM/dd/yyyy format as per argument.
	 * 
	 * @param days the days to get past date
	 * @return Past date in MM/dd/yyyy format before given days from current date
	 * @throws ParseException
	 * 
	 */
	public String PastDate(int days) throws ParseException {
		Date dateNow = new Date();
		SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
		String date_to_string = dateformatyyyyMMdd.format(dateNow);
		String untildate = date_to_string;// Current Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance(); // Get Calendar Instance
		cal.setTime(dateFormat.parse(untildate));
		// Past Date
		cal.add(Calendar.DATE, -days);
		String pastdate = dateFormat.format(cal.getTime());
		return pastdate;
	}

	/**
	 * Gets current time in the following format Month, Date, Hours, Minutes,
	 * Seconds, Millisecond.
	 * 
	 * @return Current date.
	 */
	public String getCurrentTimeStampString() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sd = new SimpleDateFormat("MMddHHmmssSS");
		TimeZone timeZone = TimeZone.getDefault();
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
		sd.setCalendar(cal);
		return sd.format(date);
	}

	/**
	 * Takes screenshot and adds it to TestNG report.
	 * 
	 * @param driver WebDriver instance.
	 */
	public void makeScreenshot(WebDriver driver, String screenshotName) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		/* Take a screenshot */
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";

		/* Copy screenshot to specific folder */
		try {
			String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator + "chrome"
					+ File.separator;
			String screenshotsFolder = "screenshots";
			File screenshotFolder = new File(reportFolder + screenshotsFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			Reporter.log("Failed to capture screenshot: " + e.getMessage());
		}
		Reporter.log(getScreenshotLink(nameWithExtention, nameWithExtention)); // add screenshot link to the report
	}

	/**
	 * Assertion to check that given element is present and show message.
	 * 
	 * @param locator the locator of element to be checked
	 * 
	 * @param message the message to be printed
	 */
	public void assert_Element_Present_With_Message(String locator, String message) {
		Assert.assertTrue(isElementPresent(locator), message);
	}
	/**
	 * Assertion to check that given element is not present and show message.
	 * 
	 * @param locator the locator of element to be checked
	 * 
	 * @param message the message to be printed
	 */
	public void assert_Element_Not_Present_With_Message(String locator, String message) {
		Assert.assertFalse(isElementPresent(locator), message);
	}
	/**
	 * Generates link for TestNG report.
	 * 
	 * @param screenshot_name Screenshot name.
	 * @param link_text       Link text.
	 * @return Formatted link for TestNG report.
	 */
	public String getScreenshotLink(String screenshot_name, String link_text) {
		Reporter.log("<Strong><font color=#FF0000>--Failed</font></strong>");
		return "<a href='../target/failsafe-reports/firefox/screenshots/" + screenshot_name + "'>" + link_text + "</a>";
	}

	/**
	 * Check that the element is displayed or not.
	 * 
	 * @param element the element to be checked
	 * 
	 * @return true if element displayed, otherwise false
	 */
	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check that the element is displayed or not.
	 * 
	 * @param element the element to be checked
	 * 
	 * @return true if element not displayed, otherwise false
	 */
	public boolean isElementNotDisplayed(String locator) {
		WebElement element = this.findElement(locator);
		try {
			return !element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check that the element is displayed or not.
	 * 
	 * @param element the element to be checked
	 * 
	 * @return true if element not displayed, otherwise false
	 */
	public boolean isElementNotDisplayed(WebElement element) {
		try {
			return !element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Assertion to check that given element is not being displayed.
	 * 
	 * @param locator the locator of element to be checked
	 */
	public void assertElementIsNotDisplayed(String locator) {
		Assert.assertFalse(isElementDisplayed(locator));
	}

	/**
	 * Wait(max. 1 minute) till given element does not disappear from page.
	 * 
	 * @param by Locator of element.
	 * @return
	 * 
	 * @throws InterruptedException
	 */
	public boolean waitForElementIsNotDisplayed(By by) throws InterruptedException {

		for (int second = 0;; second++) {
			if (second >= 60) {

				break;
			}
			try {
				if (!isElementDisplayed(by))
					break;
			} catch (Exception e) {
			}
			pause(1000);
		}
		return false;
	}

	/**
	 * Wait(max. 1 minute) till given element does not disappear from page.
	 * 
	 * @param by Locator of element.
	 * @return
	 * 
	 * @throws InterruptedException
	 */
	public boolean waitForElementIsDisplayed(By by) throws InterruptedException {

		for (int second = 0;; second++) {
			if (second >= 60) {

				break;
			}
			try {
				if (isElementDisplayed(by))
					break;
			} catch (Exception e) {
			}
			pause(1000);
		}
		return false;
	}

	/**
	 * Checks that given element is checked or not.
	 * 
	 * @param locator the locator of element to be checked
	 * 
	 * @return true if element checked,otherwise false
	 */
	public boolean isChecked(String locator) {

		return this.findElement(locator).isSelected();

	}

	/**
	 * Checks that given element is checked or not.
	 * 
	 * @param element the element to be checked
	 * 
	 * @return true if element checked,otherwise false
	 */
	public boolean isChecked(WebElement element) {
		return element.isSelected();
	}

	/**
	 * Checks whether the needed WebElement is displayed or not.
	 * 
	 * @param elementLocator
	 * @return
	 */
	public boolean isElementDisplayed(By elementLocator) {
		try {
			return driver.findElement(elementLocator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Checks whether the visibility of Element Located
	 * 
	 * @param by
	 * @return
	 */
	public ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
		return new ExpectedCondition<WebElement>() {

			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(by);
				return element.isDisplayed() ? element : null;
			}
		};
	}

	/**
	 * Wait up to String locator present
	 * 
	 * @param selector
	 */
	public void waitForElement(String selector) {
		// wait = new WebDriverWait(driver, .ofSeconds(80));
//		try {
//			wait.until(visibilityOfElementLocated(By.cssSelector(selector)));
//		} catch (TimeoutException e) {
//		}
	}

	/**
	 * Finds handle to second window other than given handle to current window and
	 * switches to as well.
	 * 
	 * @param handleCurrentWindow
	 * @return handleSecondWindow
	 * @throws InterruptedException
	 */
	public String findAndSwitchToSecondWindow(String handleCurrentWindow) throws InterruptedException {
		pause(1000);
		Set<String> windows = driver.getWindowHandles();
		String handleSecondWindow = null;
		for (String window : windows) {
			if (!window.contains(handleCurrentWindow)) {
				handleSecondWindow = window;
			}
		}
		// Switch to the second window.
		try {
			pause(2000);
			driver.switchTo().window(handleSecondWindow);
		} catch (Throwable failure) { // If there is problem in switching
			pause(1000);
			driver.switchTo().window(handleSecondWindow);
		}
		return handleSecondWindow;
	}

	/**
	 * Wait up to By element present
	 * 
	 * @param element
	 */
	public void waitForElement(By element) {
		// WebDriverWait wait = new WebDriverWait(driver, 50);
	}

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled into
	 * view and its location is calculated using getClientRects.
	 * 
	 * @param element the element to move to
	 * 
	 */
	public void mouseOver(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		highlightElement(element);
	}

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled into
	 * view and its location is calculated using getClientRects.
	 * 
	 * @param locator the locator of element to move to
	 * 
	 */
	public void mouseOver(String locator) {
		WebElement element = this.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		highlightElement(element);
	}

	/**
	 * Moves the mouse to the middle of the element and click on it. The element is
	 * scrolled into view and its location is calculated using getClientRects.
	 * 
	 * @param element the element to move to
	 * 
	 */
	public void mouseOverClick(WebElement element) {
		Actions actions = new Actions(driver);
		highlightElement(element);
		actions.moveToElement(element).click().perform();
		pause10Sec();
	}

	/**
	 * Moves the mouse to the middle of the element and click on it. The element is
	 * scrolled into view and its location is calculated using getClientRects.
	 * 
	 * @param locator the locator of element to move to
	 * 
	 */
	public void mouseOverClick(String locator) {
		WebElement element = this.findElement(locator);
		Actions actions = new Actions(driver);
		highlightElement(element);
		actions.moveToElement(element).click().perform();
		pause10Sec();
	}

	/**
	 * Get the value of the given attribute of the element. Will return the current
	 * value, even if this has been modified after the page has been loaded.
	 * 
	 * 
	 * @param locator The locator of element to get its attribute value
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getValue(String locator) {
		return this.findElement(locator).getAttribute("value");
	}

	/**
	 * Assertion to check that two values are equal.
	 * 
	 * @param value1 Value-1.
	 * @param value2 Value-2.
	 */
	public void assertTwoValuesAreEqual(Object value1, Object value2) {
		Assert.assertEquals(value1, value2);
	}

	/**
	 * Checks given element is being displayed or not on page.
	 * 
	 * @param locator the locator of element to be checked present or not
	 * 
	 * @return True if the element displayed, false otherwise
	 */
	public boolean isElementDisplayed(String locator) {
		try {
			WebElement element = this.findElement(locator);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Wait till given element is present.
	 * 
	 * @param locator the locator of element to be checked present or not.
	 */
	public void waitForConditionIsElementPresent(String locator) {
		for (int second = 0;; second++) {
			if (second >= 10) {
				break;
			}

			try {
				if (isElementPresent(locator))
					break;
			} catch (Throwable failure) {
			}
		}
	}

	/**
	 * Check that given element is present or not.
	 * 
	 * @param locator the locator of element to be checked present or not
	 * 
	 * @return True if the element present, false otherwise
	 */
	public boolean isElementPresent(String locator) {
		try {
			highlightElement(this.findElement(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check that given element is present or not.
	 * 
	 * @param xpath the xpath of element to be checked present or not
	 * 
	 * @return True if the element present, false otherwise
	 */

	public boolean existsElement(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	/**
	 * Assertion to check that given element is not present.
	 * 
	 * @param locator the locator of element
	 */
	public void assertElementNotPresent(String locator) {
		Assert.assertFalse(isElementPresent(locator));
	}

	/**
	 * Assertion to check that given element is present.
	 * 
	 * @param locator the locator of element
	 * 
	 */
	public void assertElementPresent(String locator) {
		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Causes the currently executing thread to sleep (temporarily cease execution)
	 * for the specified number of seconds, subject to the precision and accuracy of
	 * system timers and schedulers. The thread does not lose ownership of any
	 * monitors.
	 * 
	 * @param seconds the time in second to pause execution
	 */
	public void pause(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException interruptedException) {
		}
	}

	/**
	 * Wait till all ajax calls finish.
	 * 
	 * @param num Number of ajax calls to finish
	 */
	public void waitForAjax(String num) {

		String ajax;

		ajax = this.ajaxFinised(num);

		for (int second = 0;; second++) {
			if (second >= 20) {
				break;
			} else if (ajax.equals("true")) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Wait till ajax call finish.
	 * 
	 * @throws InterruptedException
	 */
	public void WaitForAjax() throws InterruptedException {

		String ajax;
		ajax = this.ajaxFinised("1");

		for (int second = 0;; second++) {
			if (second >= 15) {
				break;
			} else if (ajax.equals("true")) {
				break;
			}
			
		}
	}

	/**
	 * Checks that all ajax calls are completed on page.
	 * 
	 * @param num Number of ajax calls to wait for completion.
	 * 
	 * @return True if completed, false otherwise
	 */
	public String ajaxFinised(String num) {

		Object isAjaxFinished;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		isAjaxFinished = js.executeScript("return jQuery.active == " + num);

		return isAjaxFinished.toString();

	}

	/**
	 * Determine whether or not given string contains numeral.
	 * 
	 * @return True if the string contains numeral, false otherwise
	 */
	public boolean isContainsNumeral(String string) {
		for (int i = 0; i < 9; i++) {
			if (string.contains("" + i + "")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Causes the currently executing thread to sleep (temporarily cease execution)
	 * for the specified number of milliseconds, subject to the precision and
	 * accuracy of system timers and schedulers. The thread does not lose ownership
	 * of any monitors.
	 * 
	 */
	public void pause10Sec() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {

		}
	}

	/**
	 * Wait until visibility of given element.
	 * 
	 * @param locator the locator of element
	 *
	 */
	public void waitUntillElementPresent(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	// Save Screenshot for the Report

	public void makeScreenshotForReport(WebDriver driver, String screenshotName) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		/* Take a screenshot */
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";
		/* Copy screenshot to specific folder */
		try {
			String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator;
			File screenshotFolder = new File(reportFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			logPrint("Failed to capture screenshot: " + e.getMessage());
		}
	}

	public String readJson(String Key) throws IOException, org.json.simple.parser.ParseException {
		JSONParser jsonparsor = new JSONParser();
		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\auction\\utils\\Parameters.json");
		Object obj = jsonparsor.parse(reader);
		JSONArray userList = (JSONArray) obj;
		JSONObject parameters = (JSONObject) userList.get(0);
		String Value = (String) parameters.get(Key);
		return Value;
	}

	/**
	 * Upload file using robot class.
	 * 
	 * @param file the path of file to be uploaded
	 * @throws AWTException
	 */
	public void upload_File_Using_Robot(String file) throws AWTException {

		String path_win = System.getProperty("user.dir") + file;
		StringSelection filepath = new StringSelection(path_win);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, filepath);
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		robot.delay(1000);
	}

	/**
	 * Returns the number of elements in this list. If this list contains more than
	 * {@code Integer.MAX_VALUE} elements, returns {@code Integer.MAX_VALUE}.
	 *
	 * @param element the element to get size
	 * @return the number of elements in this list
	 */

	public int size(List<WebElement> element) {
		return element.size();
	}

	/**
	 * Returns the number of elements in this list. If this list contains more than
	 * {@code Integer.MAX_VALUE} elements, returns {@code Integer.MAX_VALUE}.
	 *
	 * @param locator the locator of element to find list to get size
	 * @return the number of elements in this list
	 */

	public int size(String locator) {
		return findElements(locator).size();
	}

	/**
	 * <p>
	 * Log the passed string to the HTML reports.
	 * </p>
	 * 
	 * <p>
	 * Print the passed string and then terminates the line.
	 * </p>
	 * 
	 * @param message the message to log and to print
	 */
	public void logPrint(String message) {
		Reporter.log("<br></br>" + message);
		System.out.println(message);
	}

	/**
	 * Select all options that have a value matching the argument.
	 *
	 * @param value   the value to match against
	 * @param locator the locator of element to be selected by value
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 * 
	 */
	public void selectByValue(String value, String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
		pause10Sec();							
	}

	/**
	 * Select all options that have a value matching the argument.
	 *
	 * @param value   the value to match against
	 * @param element the element to be selected by value
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 * 
	 */
	public void selectByValue(String value, WebElement element) {
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
		pause10Sec();		
	}

	/**
	 * Select the option at the given index. This is done by examining the "index"
	 * attribute of an element, and not merely by counting.
	 *
	 * @param index   the option at this index will be selected
	 * @param locator the locator of element to be selected by index.
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByIndex(int index, String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
		pause10Sec();
		
	}

	/**
	 * Select the option at the given index. This is done by examining the "index"
	 * attribute of an element, and not merely by counting.
	 *
	 * @param index   the option at this index will be selected
	 * @param element the element to be selected by index
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByIndex(int index, WebElement element) {
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
		pause10Sec();
		
	}

	/**
	 * Select the option of given element at random index. This is done by examining
	 * the "index" attribute of an element, and not merely by counting.
	 *
	 * @param locator the locator of element to be selected by random index
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByRandomIndex(String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		Select dropdown = new Select(element);
		Random random = new Random();
		dropdown.selectByIndex(random.nextInt(dropdown.getOptions().size()));
		pause(1);
		handleAlert();
		pause10Sec();
		
	}

	/**
	 * Select the option of given element at random index. This is done by examining
	 * the "index" attribute of an element, and not merely by counting.
	 *
	 * @param element the element to be selected by random index.
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByRandomIndex(WebElement element) {
		highlightElement(element);
		Select dropdown = new Select(element);
		Random random = new Random();
		dropdown.selectByIndex(random.nextInt(dropdown.getOptions().size()));
		handleAlert();
		pause10Sec();
	}

	/**
	 * Select all options of given element that display text matching the argument.
	 *
	 * 
	 * @param text    the visible text to match against
	 * @param locator the locator of element to be selected by visible text.
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByVisibleText(String text, String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
		pause10Sec();		
	}

	/**
	 * Select all options of given element that display text matching the argument.
	 *
	 * 
	 * @param text    the visible text to match against
	 * @param element the element to be selected by visible text
	 * @return The element's current visible text after selection or null if the
	 *         value is not set.
	 */
	public void selectByVisibleText(String text, WebElement element) {
		highlightElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
		pause10Sec();		
	}
	/**
	 * Get first selected option from dropdown.
	 *
	 * 
	 * @param locator the locator of element to get first selected option text.
	 * @return The element's current visible text or null if the
	 *         value is not set.
	 * 
	 */
	public String getFirstSelectedOptionOfDropdown(String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		Select dropdown = new Select(element);
		return dropdown.getFirstSelectedOption().getText();
	}
	/**
	 * Get first selected option from dropdown.
	 *
	 * 
	 * @param element the element to get first selected option text.
	 * @return The element's current visible text or null if the
	 *         value is not set.
	 * 
	 */
	public String getFirstSelectedOptionOfDropdown(WebElement element) {
		
		highlightElement(element);
		Select dropdown = new Select(element);
		return dropdown.getFirstSelectedOption().getText();
	}

	/**
	 * Check the checkbox or toggle element.
	 * 
	 * @param locator the locator of checkbox element to be checked
	 */
	public void checkChkBox(String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (!isCheckBoxChecked) {
			element.click();
		}
	}

	/**
	 * Check the checkbox or toggle element.
	 * 
	 * @param element The checkbox element to be checked
	 */
	public void checkChkBox(WebElement element) {
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (!isCheckBoxChecked) {
			element.click();
		}
	}

	/**
	 * Uncheck the checkbox or toggle element.
	 * 
	 * @param locator the locator of checkbox element to be unchecked
	 */
	public void uncheckChkBox(String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (isCheckBoxChecked) {
			element.click();
		}
	}

	/**
	 * Uncheck the checkbox or toggle element.
	 * 
	 * @param element The checkbox element to be unchecked
	 */
	public void uncheckChkBox(WebElement element) {
		highlightElement(element);
		boolean isCheckBoxChecked = element.isSelected();
		if (isCheckBoxChecked) {
			element.click();
		}
	}

	/**
	 * Scroll to bottom of the page.
	 *
	 * 
	 */
	public void scroll_To_Bottom_Of_Page() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		pause(1);
	}

	/**
	 * Scroll page to element for given locator.
	 *
	 * @param locator the locator of element where to scroll
	 * 
	 */
	public void scroll_To_Element(String locator) {
		WebElement element = this.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		pause(1);
	}

	/**
	 * Scroll page to given x and y pixels position.
	 * 
	 * @param x_pixels The x-pixels is the number at x-axis, it moves to the left if
	 *                 number is positive and it move to the right if number is
	 *                 negative
	 * 
	 * @param y_pixels The y-pixels is the number at y-axis, it moves to the down if
	 *                 number is positive and it move to the up if number is in
	 *                 negative
	 * 
	 **/
	public void scroll_By_Pixel(String x_pixels, String y_pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x_pixels + "," + y_pixels + ")", "");
		pause(1);
	}

	/**
	 * <p>
	 * Creates a random character string whose length is the number of characters
	 * specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of alphabetic characters.
	 * </p>
	 *
	 * @param length the length of random character string to create
	 * @return The random character string in lower case
	 */
	public static String generateRandomChars(int length) {
		return RandomStringUtils.randomAlphabetic(length).toLowerCase();
	}

	/**
	 * <p>
	 * Creates a random number integer whose length is the number of characters
	 * specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of numeric characters.
	 * </p>
	 *
	 * @param length the length of random number integer to create
	 * @return The random number integer
	 */
	public static int generateRandomNumberInteger(int length) {
		String randomNumeric = RandomStringUtils.randomNumeric(length);
		return Integer.parseInt(randomNumeric);
	}

	/**
	 * <p>
	 * Creates a random number string whose length is the number of characters
	 * specified.
	 * </p>
	 *
	 * <p>
	 * Characters will be chosen from the set of numeric characters.
	 * </p>
	 *
	 * @param length the length of random number string to create
	 * @return The random number string
	 */
	public static String generateRandomNumberString(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	/**
	 * Highlight given element
	 * 
	 * @param locator the locator of element to be highlighted
	 * 
	 */
	public void highlightElement(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", this.findElement(locator));
	}

	/**
	 * Highlight given element
	 * 
	 * @param element the element to be highlighted
	 * 
	 */
	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
	}

	/**
	 * Get a string representing the current URL that the browser is looking at.
	 * 
	 * @return The URL of the page currently loaded in the browser
	 */
	public String installation_URL() {
		String installurl = driver.getCurrentUrl();
		logPrint("Installation URL :: " + installurl);
		return installurl;
	}

	/**
	 * Get the system OS name.
	 * 
	 * @return The string value of the system OS name
	 */
	public String getOS() {
		String OS = System.getProperty("os.name").toLowerCase();
		logPrint("-----------------------------------------------------------------------------------");
		logPrint("System OS :: " + OS);
		logPrint("-----------------------------------------------------------------------------------");
		return OS;
	}

	/**
	 * Find the first {@link WebElement} using the given method. This method is
	 * affected by the 'implicit wait' times in force at the time of execution. The
	 * findElement(..) invocation will return a matching row, or try again
	 * repeatedly until the configured timeout is reached.
	 * 
	 * 
	 * @param locator the locator to be used by locating mechanism to find element
	 * @return The first matching element on the current page
	 * @throws NoSuchElementException If no matching elements are found
	 * 
	 */
	public WebElement findElement(String locator) {
		if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
			locator = locator.substring(5); // remove "link=" from locator
			if (locator.contains(" "))
				return driver.findElement(By.partialLinkText(locator));
			return driver.findElement(By.linkText(locator));
		} else if (locator.startsWith("id=")) {
			locator = locator.substring(3); // remove "id=" from locator
			return driver.findElement(By.id(locator));
		} else if (locator.startsWith("//")) {
			return driver.findElement(By.xpath(locator));
		} else if (locator.startsWith("#")) {
			return driver.findElement(By.cssSelector(locator));
		} else if (locator.startsWith("name=")) {
			locator = locator.substring(5); // remove "name=" from locator
			return driver.findElement(By.name(locator));
		} else if (locator.startsWith("class=")) {
			locator = locator.substring(6); // remove "class=" from locator
			return driver.findElement(By.className(locator));
		} else if (locator.equalsIgnoreCase("body")) {
			return driver.findElement(By.cssSelector(locator));
		} else {
			return driver.findElement(By.id(locator));
		}
	}

	/**
	 * Find all elements within the current page using the given mechanism. This
	 * method is affected by the 'implicit wait' times in force at the time of
	 * execution. When implicitly waiting, this method will return as soon as there
	 * are more than 0 items in the found collection, or will return an empty list
	 * if the timeout is reached.
	 * 
	 *
	 * @param locator the locator to be used by locating mechanism to find elements
	 * @return A list of all matching {@link WebElement}s, or an empty list if
	 *         nothing matches
	 * 
	 */
	public List<WebElement> findElements(String locator) {
		if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
			locator = locator.substring(5); // remove "link=" from locator
			if (locator.contains(" "))
				return driver.findElements(By.partialLinkText(locator));
			return driver.findElements(By.linkText(locator));
		} else if (locator.startsWith("id=")) {
			locator = locator.substring(3); // remove "id=" from locator
			return driver.findElements(By.id(locator));
		} else if (locator.startsWith("//")) {
			return driver.findElements(By.xpath(locator));
		} else if (locator.startsWith("#")) {
			return driver.findElements(By.cssSelector(locator));
		} else if (locator.startsWith("name=")) {
			locator = locator.substring(5); // remove "name=" from locator
			return driver.findElements(By.name(locator));
		} else if (locator.startsWith("class=")) {
			locator = locator.substring(6); // remove "class=" from locator
			return driver.findElements(By.className(locator));
		} else if (locator.equalsIgnoreCase("body")) {
			return driver.findElements(By.cssSelector(locator));
		} else {
			return driver.findElements(By.id(locator));
		}
	}

	/**
	 * Refresh the current page
	 * 
	 */
	public void refreshPage() {
		driver.navigate().refresh();
		pause10Sec();
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element, which may set its value.
	 * 
	 * 
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 * 
	 */

	public void type(String locator, String keysToSend) {

		WebElement element = this.findElement(locator);
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element, which may set its value.
	 * 
	 * 
	 * @param element    the element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 * 
	 */
	public void type(WebElement element, String keysToSend) {
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element, which may set its value and press ENTER
	 * key.
	 * 
	 * 
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 * 
	 */

	public void typeAndEnter(String locator, String keysToSend) {

		WebElement element = this.findElement(locator);
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		element.sendKeys(Keys.ENTER);
		pause10Sec();
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element, which may set its value and press ENTER
	 * key.
	 * 
	 * 
	 * @param element    the element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 * 
	 */

	public void typeAndEnter(WebElement element, String keysToSend) {

		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		element.sendKeys(Keys.ENTER);
		pause10Sec();
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element,then select first option from list.
	 * 
	 * 
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 * 
	 */

	public void typeAndSelectFirst(String locator, String keysToSend) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		pause(1);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
		pause10Sec();
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element,then select first option from list.
	 * 
	 * 
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 * 
	 */

	public void typeAndSelectFirst(WebElement element, String keysToSend) {
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		pause(1);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN, Keys.RETURN).build().perform();
		pause10Sec();
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element,then select second option from list.
	 * 
	 * 
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 * 
	 */

	public void typeAndSelectSecond(String locator, String keysToSend) {

		WebElement element = this.findElement(locator);
		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		pause(1);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.RETURN).build().perform();
		pause10Sec();
	}

	/**
	 * If given element is a form entry element, this will reset its value first
	 * then simulate typing into an element,then select second option from list.
	 * 
	 * 
	 * @param locator    The locator of element where to send keys
	 * @param keysToSend the character sequence to send to the element
	 * 
	 */

	public void typeAndSelectSecond(WebElement element, String keysToSend) {

		highlightElement(element);
		element.clear();
		element.sendKeys(keysToSend);
		pause(1);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.RETURN).build().perform();
		pause10Sec();
	}

	/**
	 * Click on given element. If this causes a new page to load, you should discard
	 * all references to given element and any further operations performed on given
	 * element will throw a StaleElementReferenceException.
	 * 
	 * There are some preconditions for an element to be clicked. the element must
	 * be visible and it must have a height and width greater then 0.
	 * 
	 * @param locator the locator of element to be clicked.
	 */
	public void click(String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		element.click();
		pause10Sec();
	}

	/**
	 * Click on given element. If this causes a new page to load, you should discard
	 * all references to given element and any further operations performed on given
	 * element will throw a StaleElementReferenceException.
	 * 
	 * There are some preconditions for an element to be clicked. the element must
	 * be visible and it must have a height and width greater then 0.
	 * 
	 * @param element the element to be clicked.
	 */

	public void click(WebElement element) {
		highlightElement(element);
		element.click();
		pause10Sec();
	}

	/**
	 * Clicks on visible or not visible element through javascript.
	 * 
	 * @param locator the locator of element to be clicked.
	 */
	public void jsClick(String locator) {
		WebElement element = this.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		js.executeScript("return arguments[0].click();", element);
		pause10Sec();
	}

	/**
	 * Clicks on visible or not visible element through javascript.
	 * 
	 * @param element the element to be clicked.
	 */
	public void jsClick(WebElement element) {
		highlightElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].click();", element);
		pause10Sec();
	}

	/**
	 * If given element is a form entry element, this will reset its value.
	 * 
	 * @param locator the locator of element to be cleared
	 */
	public void clear(String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		element.clear();
	}

	/**
	 * If given element is a form entry element, this will reset its value.
	 * 
	 * @param element the element to be cleared
	 */
	public void clear(WebElement element) {
		highlightElement(element);
		element.clear();
	}

	/**
	 * Get the value of the given attribute of the element. Will return the current
	 * value, even if this has been modified after the page has been loaded.
	 * <p>
	 * More exactly, this method will return the value of the property with the
	 * given name, if it exists. If it does not, then the value of the attribute
	 * with the given name is returned. If neither exists, null is returned.
	 * <p>
	 * To get tooltip you have to give attribute "title" as argument.
	 * <p>
	 * The "style" attribute is converted as best can be to a text representation
	 * with a trailing semi-colon.
	 * <p>
	 * The following are deemed to be "boolean" attributes, and will return either
	 * "true" or null:
	 * <p>
	 * async, autofocus, autoplay, checked, compact, complete, controls, declare,
	 * defaultchecked, defaultselected, defer, disabled, draggable, ended,
	 * formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope,
	 * loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open,
	 * paused, pubdate, readonly, required, reversed, scoped, seamless, seeking,
	 * selected, truespeed, willvalidate
	 * <p>
	 * Finally, the following commonly mis-capitalized attribute/property names are
	 * evaluated as expected:
	 * <ul>
	 * <li>If the given name is "class", the "className" property is returned.
	 * <li>If the given name is "readonly", the "readOnly" property is returned.
	 * </ul>
	 * 
	 * @param locator       The locator of element to get its attribute value
	 * @param attributeName The name of the attribute
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getAttribute(String locator, String attributeName) {

		WebElement element = this.findElement(locator);
		highlightElement(element);
		return element.getAttribute(attributeName);
	}

	/**
	 * Get the value of the given attribute of the element. Will return the current
	 * value, even if this has been modified after the page has been loaded.
	 * <p>
	 * More exactly, this method will return the value of the property with the
	 * given name, if it exists. If it does not, then the value of the attribute
	 * with the given name is returned. If neither exists, null is returned.
	 * <p>
	 * The "style" attribute is converted as best can be to a text representation
	 * with a trailing semi-colon.
	 * <p>
	 * The following are deemed to be "boolean" attributes, and will return either
	 * "true" or null:
	 * <p>
	 * async, autofocus, autoplay, checked, compact, complete, controls, declare,
	 * defaultchecked, defaultselected, defer, disabled, draggable, ended,
	 * formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope,
	 * loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open,
	 * paused, pubdate, readonly, required, reversed, scoped, seamless, seeking,
	 * selected, truespeed, willvalidate
	 * <p>
	 * Finally, the following commonly mis-capitalized attribute/property names are
	 * evaluated as expected:
	 * <ul>
	 * <li>If the given name is "class", the "className" property is returned.
	 * <li>If the given name is "readonly", the "readOnly" property is returned.
	 * </ul>
	 * 
	 * @param element       the element to get its attribute value
	 * @param attributeName The name of the attribute
	 * @return The attribute/property's current value or null if the value is not
	 *         set.
	 */
	public String getAttribute(WebElement element, String attributeName) {

		return element.getAttribute(attributeName);
	}

	/**
	 * Get the visible (i.e. not hidden by CSS) text of given element, including
	 * sub-elements.
	 * 
	 * @param locator the locator of element from where to get visible text
	 * @return The visible text of given element.
	 */

	public String getText(String locator) {

		WebElement element = this.findElement(locator);
		highlightElement(element);
		return element.getText();
	}

	/**
	 * Get the visible (i.e. not hidden by CSS) text of given element, including
	 * sub-elements.
	 * 
	 * @param element the element from where to get visible text
	 * @return The visible text of given element.
	 */
	public String getText(WebElement element) {
		highlightElement(element);
		return element.getText();
	}

	/**
	 * Get the visible text of given element's tooltip.
	 * 
	 * @param locator the locator of element from where to get tooltip text
	 * @return The tooltip text of given element.
	 */

	public String getToolTipText(String locator, String tooltipLocator) {
		WebElement element = this.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		WebElement toolTip = this.findElement(tooltipLocator);
		highlightElement(toolTip);
		return toolTip.getText();
	}

	/**
	 * Get the visible text of given element's tooltip.
	 * 
	 * @param locator the locator of element from where to get tooltip text
	 * @return The tooltip text of given element.
	 */

	public String getToolTipText(WebElement element, String tooltipLocator) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		WebElement toolTip = this.findElement(tooltipLocator);
		highlightElement(toolTip);
		return toolTip.getText();
	}

	/**
	 * Select a frame using its previously located {@link WebElement}.
	 * 
	 * @param locator The locator of frame element to switch to.
	 * @return This driver focused on the given frame.
	 * 
	 */
	public void switchToFrame(String locator) {
		WebElement element = this.findElement(locator);
		driver.switchTo().frame(element);
	}

	/**
	 * Select a frame using its previously located {@link WebElement}.
	 * 
	 * @param element The frame element to switch to.
	 * @return This driver focused on the given frame.
	 * 
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * Select a frame by its (zero-based) index. Selecting a frame by index is
	 * equivalent to the JS expression window.frames[index] where "window" is the
	 * DOM window represented by the current context. Once the frame has been
	 * selected, all subsequent calls on the WebDriver interface are made to that
	 * frame.
	 * 
	 * @param index (zero-based) index.
	 * @return This driver focused on the given frame.
	 * 
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * Selects either the first frame on the page, or the main document when a page
	 * contains iframes.
	 * 
	 * @return This driver focused on the top window/first frame.
	 * 
	 */
	public void switchToFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Search the option in given element (Dropdown list). This is done by examining
	 * each and every options available in dropdown list.
	 *
	 * @param option  the option which you want to check presence in dropdown list
	 * @param locator the locator of element to be searched for option
	 * @return True if option present in dropdown list, otherwise false
	 * 
	 */
	public Boolean isOptionPresentInDropdown(String option, String locator) {
		WebElement element = this.findElement(locator);
		highlightElement(element);
		Select dropdown = new Select(element);
		int totalOptions = dropdown.getOptions().size();
		for (int i = 0; i < totalOptions; i++) {
			if (dropdown.getOptions().get(i).getText().contains(option))
				return true;
		}
		return false;

	}

	/**
	 * Search the option in given element (Dropdown list). This is done by examining
	 * each and every options available in dropdown list.
	 *
	 * @param option  the option which you want to check presence in dropdown list
	 * @param element the element to be searched for option
	 * @return True if option present in dropdown list, otherwise false
	 * 
	 */
	public Boolean isOptionPresentInDropdown(String option, WebElement element) {

		highlightElement(element);
		Select dropdown = new Select(element);
		int totalOptions = dropdown.getOptions().size();
		for (int i = 0; i < totalOptions; i++) {
			if (dropdown.getOptions().get(i).getText().contains(option))
				return true;
		}
		return false;
	}

	/**
	 * Assertion to check that given element is checked.
	 * 
	 * @param locator the locator of element to be checked
	 * 
	 */
	public void assertCheckboxChecked(String locator) {
		Assert.assertTrue(isChecked(locator));
	}

	/**
	 * Assertion to check that given element is checked.
	 * 
	 * @param element the element to be checked
	 * 
	 */

	public void assertCheckboxChecked(WebElement element) {
		Assert.assertTrue(isChecked(element));
	}

	/**
	 * Assertion to check that given element is not checked.
	 * 
	 * @param locator the locator of element to be checked
	 * 
	 */
	public void assertCheckboxNotChecked(String locator) {
		Assert.assertTrue(!isChecked(locator));
	}

	/**
	 * Assertion to check that given element is not checked.
	 * 
	 * @param element the element to be checked
	 * 
	 */
	public void assertCheckboxNotChecked(WebElement element) {
		Assert.assertTrue(!isChecked(element));
		
	}
	// e c f t
	
	//Search this ("placeholder");
}

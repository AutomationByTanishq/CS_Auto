package Config;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Common extends Configuration{

    public WebDriver driver;

    public Common(WebDriver driver) {
        this.driver = driver;
    }

    private static final TimeUnit SECONDS = null;
    Date date = new Date();
    protected Wait<WebDriver> wait;

    /**
     * Find web-element for given locator.
     * f
     * @param elementName
     * @return
     */
    public WebElement findElement(String elementName) {

        String locator;

        locator = elementName;

        int count = 0;
        while (count < 4) {
            try {
                if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
                    locator = locator.substring(5); // remove "link=" from
                    // locator
                    try {
                        if (locator.contains(" "))
                            return driver.findElement(By.partialLinkText(locator));

                        return driver.findElement(By.linkText(locator));
                    } catch (Exception e) {
                        return null;
                    }
                }
                if (locator.startsWith("id=")) {
                    locator = locator.substring(3); // remove "id=" from locator
                    try {
                        return driver.findElement(By.id(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else if (locator.startsWith("//")) {
                    try {
                        return driver.findElement(By.xpath(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else if (locator.startsWith("css=")) {

                    locator = locator.substring(4); // remove "css=" from
                    // locator
                    try {
                        return driver.findElement(By.cssSelector(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else if (locator.startsWith("name=")) {

                    locator = locator.substring(5); // remove "name=" from
                    // locator
                    try {
                        return driver.findElement(By.name(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else {
                    try {
                        return driver.findElement(By.id(locator));
                    } catch (Exception e) {
                        return null;
                    }

                }
            } catch (StaleElementReferenceException e) {
                e.toString();

                count = count + 1;
                // System.out.println("Trying["+
                // count+"] to recover from a stale element :" +
                // e.getMessage());
            }
            count = count + 4;
        }
        return null;

    }

    public void dismissAlert() {

        pause(4);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

    }

    public String acceptAlert1() {

        pause(4);
        Alert alert = driver.switchTo().alert();
        String alerttext = alert.getText();

        alert.accept();
        return alerttext;
    }





    /**
     * Refresh Page
     *
     */
    public void refreshPage() {

        driver.navigate().refresh();
    }

    /**
     * Clicks on visible or not visible element.
     *
     * @param element Web element.
     */
    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("return arguments[0].click();", element);
        // this.waitForAjax("0");
    }

    /**
     * Current Date to Tomorrow's Date
     *
     * @throws ParseException
     *
     */
    public String currentDate() throws ParseException {

        Date dateNow = new Date();
        SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd"); // Date
        // Format
        String date_to_string = dateformatyyyyMMdd.format(dateNow);
        String untildate = date_to_string; // Current Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format

        return untildate;

    }

    /**
     * TomorrowDate
     *
     * @return
     * @throws ParseException
     */
    public String tomorrowDate() throws ParseException, java.text.ParseException {

        Date dateNow = new Date();
        SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd"); // Date
        // Format
        String date_to_string = dateformatyyyyMMdd.format(dateNow);
        String untildate = date_to_string;// Current Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance(); // Get Calendar Instance
        cal.setTime(dateFormat.parse(untildate));

        // Tomorrow's Date
        cal.add(Calendar.DATE, 1); // Date Increase by One
        String convertedDate = dateFormat.format(cal.getTime());
        System.out.println("Date increase by one :: " + convertedDate);

        return convertedDate;

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
     * Log given message to Reporter output.
     *
     * @param msg Message/Log to be reported.
     */
    public void log(String msg) {
        Reporter.log(msg);
        System.out.println(msg);
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
     * Wait up to By element present
     *
     * @param element
     */
//	public void waitForElement(By element) {
//		wait = new WebDriverWait(driver, 80);
//		try {
//			wait.until(visibilityOfElementLocated(element));
//		} catch (TimeoutException e) {
//		}
//	}

    /**
     * Generates random symbols;
     *
     * @param length Length of the generated symbols.
     *
     * @return StringBuffer object.
     */
    public static String generateRandomChars(int length) {
        String total = "iokijfmnbxcvfrpqsdfgvcxzdferiuytjndifur";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char _char = total.charAt((int) (Math.random() * 100) % total.length());
            buf.append(_char);
        }
        return buf.toString();
    }

    /**
     * Generate Random Number in Length
     *
     * @param length
     * @return
     */
    public static int GenerateRandomNumber(int length) {

        Random rand = new Random();
        int num = rand.nextInt(length);
        int numNoRange = rand.nextInt();
        return numNoRange;

    }

    public static int RandomNum(int length) {
        Random rand = new Random();
        for (int i = 1; i <= 100; i++) {
            int num = rand.nextInt(length);
            int randomNum = rand.nextInt((999 - 100) + 1) + 100;
            return randomNum;
        }
        return length;

    }


    /**
     * Generate Random Number1
     *
     * @param
     * @return
     */
    public static String generateRandomNumber1() {

        String result = null;
        for (int i = 1; i < 12; i++) {
            int Random = (int) (Math.random() * 1000000000);
            result = String.valueOf(Random);
        }
        return result;

        // return RandomStringUtils.randomNumeric(length);
    }

    public final static String createRandomNumber(long len) {
        if (len > 18)
            throw new IllegalStateException("To many digits");
        long tLen = (long) Math.pow(10, len - 1) * 9;

        long number = (long) (Math.random() * tLen) + (long) Math.pow(10, len - 1) * 1;

        String tVal = number + "";
        if (tVal.length() != len) {
            throw new IllegalStateException("The random number '" + tVal + "' is not '" + len + "' digits");
        }
        return tVal;
    }

    /**
     * Generate Random Number 12
     *
     * @param
     * @return
     */
    public static long numbGen() {
        while (true) {
            long numb = (long) (Math.random() * 100000000 * 1000000); // had to use this as int's are to small for a 13
            // digit number.
            if (String.valueOf(numb).length() == 10)
                return numb;
        }
    }

    private static int random_float() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Get text in a given element.
     *
     * @param elementName Locator of element.
     *
     * @return text in given element.
     */
    public String getText(String elementName) {

        String text;

        try {
            text = this.findElement(elementName).getText();

        } catch (Exception e) {

            text = "Element was not found";
        }

        return text;
    }

    public void open(String url) {

        driver.get(url);
    }

    /**
     * Get value of given element dynamically.
     *
     * @param locator Locator of element.
     *
     * @return Dynamic value.
     */
    public String getValue(String locator) {

        return this.findElement(locator).getAttribute("value");
    }

    /**
     * Checks if given element is being displayed on page.
     *
     * @param elementName Locator of element.
     *
     * @return true if displayed else false.
     */
    public boolean isElementDisplayed(String elementName) {
        try {
//            WebDriverWait wait = new WebDriverWait(driver, 50);  //WebDriverWait(driver,800);
//            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementName)));
////			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
//            driver.findElement(By.xpath(elementName)).isDisplayed();


            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

//            wait.until(new Function<WebDriver, WebElement>() {
//
//                       }

            WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.id("foo"));
                }
            });

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void wait_until_element_present(String locator){
        WebDriverWait wait =new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
    }

    public Boolean isDisplayed(String locator){
        try{
            driver.findElement(By.xpath(locator));
            return true;
    } catch (Exception e) {
        return false;
    }
    }

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
     * @param locator Locator of element.
     */
    public void assertElementNotPresent(String locator) {

        Assert.assertFalse(isElementPresent(locator));
    }

    /**
     * Assertion to check that given element is present.
     *
     * @param locator Locator of element.
     */
    public void assertElementPresent(String locator) {

        Assert.assertTrue(isElementPresent(locator));
    }

    /**
     * Pauses for given seconds.
     *
     * @param secs
     */
    public void pause(int secs) {
        try {
            Thread.sleep(secs * 200);
        } catch (InterruptedException interruptedException) {

        }
    }

    /**
     * Clears and type new value into given text-box.
     *
     * @param locator
     *
     * @param string  New text/value.
     */
    public void type(String locator, String string) {

        this.findElement(locator).clear();
        this.findElement(locator).sendKeys(string);

    }

//	/**
//	 * Generates link for TestNG report.
//	 *
//	 * @param screenshot_name Screenshot name.
//	 * @param link_text       Link text.
//	 * @return Formatted link for TestNG report.
//	 */
//	public String getScreenshotLink(String screenshot_name, String link_text) {
//		this.log("<Strong><font color=#FF0000>--Failed</font></strong>");
//		return "<a href='../target/failsafe-reports/firefox/screenshots/" + screenshot_name + "'>" + link_text + "</a>";
//	}
//
//
//	/**
//	 * Takes screenshot and adds it to TestNG report.
//	 *
//	 * @param driver WebDriver instance.
//	 */
//	public void makeScreenshotForReport(WebDriver driver, String screenshotName) {
//		WebDriver augmentedDriver = new Augmenter().augment(driver);
//		/* Take a screenshot */
//		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
//		String nameWithExtention = screenshotName + ".png";
//
//		/* Copy screenshot to specific folder */
//		try {
//			String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator + "chrome"
//					+ File.separator;
//			String screenshotsFolder = "screenshots";
//			File screenshotFolder = new File(reportFolder + screenshotsFolder);
//			if (!screenshotFolder.getAbsoluteFile().exists()) {
//				screenshotFolder.mkdir();
//			}
//			FileUtils.copyFile(screenshot,
//					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
//		} catch (IOException e) {
//			Reporter.log("Failed to capture screenshot: " + e.getMessage());
//		}
//		this.log(getScreenshotLink(nameWithExtention, nameWithExtention)); // add screenshot link to the report
//	}





//	public void makeScreenshot(WebDriver driver, String screenshotName) {
//		WebDriver augmentedDriver = new Augmenter().augment(driver);
//		/* Take a screenshot */
//		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
//		String nameWithExtention = screenshotName + ".png";
//
//		/* Copy screenshot to specific folder */
//		try {
//			String reportFolder = "target" + File.separator + "surefire-reports" + File.separator + "chrome"
//					+ File.separator;
//			String screenshotsFolder = "screenshots";
//			File screenshotFolder = new File(reportFolder + screenshotsFolder);
//			if (!screenshotFolder.getAbsoluteFile().exists()) {
//				screenshotFolder.mkdir();
//			}
//			FileUtils.copyFile(screenshot,
//					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
//		} catch (IOException e) {
//			Reporter.log("Failed to capture screenshot: " + e.getMessage());
//		}
////		Reporter.log(getScreenshotLink(nameWithExtention, nameWithExtention)); // add screenshot link to the report
//	}



//	public void makeScreenshotForReport(WebDriver driver, String screenshotName) {
//		WebDriver augmentedDriver = new Augmenter().augment(driver);
//		/* Take a screenshot */
//		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
//		String nameWithExtention = screenshotName + ".png";
//		/* Copy screenshot to specific folder */
//		try {
//			String reportFolder = "target" + File.separator + "surefire-reports" + File.separator;
//			File screenshotFolder = new File(reportFolder);
//			if (!screenshotFolder.getAbsoluteFile().exists()) {
//				screenshotFolder.mkdir();
//			}
//			FileUtils.copyFile(screenshot, new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
//		} catch (IOException e) {
//			logPrint("Failed to capture screenshot: " + e.getMessage());
//		}
//
////		Reporter.log("<a href='"+nameWithExtention+"'> <img src='"+nameWithExtention+"' height='500' width='500'></img> </a>");
//	}


    public String getScreenshotLink(String screenshot_name, String link_text) {
        Reporter.log("<Strong><font color=#FF0000>--Failed</font></strong>");
        return "<a href='../target/surefire-reports" + screenshot_name + "'>" + link_text + "</a>";
    }

    public void logPrint(String message) {
        Reporter.log(message);
        System.out.println(message);
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
            String reportFolder = "target" + File.separator + "surefire-reports"
                    + File.separator;

            File screenshotFolder = new File(reportFolder);
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


    // Save Screenshot for the Report

    public void makeScreenshotForReport(WebDriver driver, String screenshotName) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        /* Take a screenshot */
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";
        /* Copy screenshot to specific folder */
        try {
            String reportFolder = "target" + File.separator + "surefire-reports" + File.separator;
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



    /**
     * Get Current Time
     *
     * @return
     */

    public String current_time() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy --- HH_mm_ss_a");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now)); // 2016/11/16 12:08:43
        return dtf.format(now);
    }

    public void Scrollpage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1500)", "");

    }

    /**
     * Wait till given element is present.
     *
     * @param locator Locator of element.
     */
    public void waitForConditionIsElementPresent(String locator) {

        for (int second = 0;; second++) {
            if (second >= 80) {
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
     * Checks if element loaded in browser memory.
     *
     * @param locator Locator of element.
     * @return true if loaded else false.
     */
    public boolean isElementPresent(String locator) {

        WebElement webElement = this.findElement(locator);
        if (webElement != null) {
            return true;
        } else {

            return false;
        }
    }

    /**
     * For select value from dropdown
     *
     * @param dropdwon
     * @param elementLocator
     */
    public void dropdownmenu(String dropdwon, String elementLocator) {

        Select dropdown = new Select(driver.findElement(By.id(elementLocator)));
        dropdown.selectByValue(dropdwon);
    }

    /**
     * Wait up to String locator present
     *
     * @param selector
     */
//	public void waitForElement(String selector) {
//		wait = new WebDriverWait(driver, 30);
//		try {
//			wait.until(visibilityOfElementLocated(By.cssSelector(selector)));
//		} catch (TimeoutException e) {
//		}
//	}

    /**
     * Checks whether the needed WebElement is displayed or not.
     *
     * @param element Needed element
     *
     * @return true or false.
     */
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementNotDisplayed(WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
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
     * Wait(max. 1 minute) till given element does not disappear from page.
     *
     * @param by Locator of element.
     * @return
     *
     * @throws InterruptedException
     */
    public boolean waitForElementIsDisplayed(By by) throws InterruptedException {

        for (int second = 0;; second++) {
            if (second >= 10) {

                break;
            }
            try {
                if (isElementDisplayed(by))
                    break;
            } catch (Exception e) {
            }
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

    public String read_json(String Json_Key) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/User_Creds.json");
        Object obj = jsonParser.parse(reader);
        JSONArray usersList = (JSONArray) obj;
        JSONObject user = (JSONObject) usersList.get(0);
        String Name = (String)user.get(Json_Key);
        return Name;
    }

    public void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }


}
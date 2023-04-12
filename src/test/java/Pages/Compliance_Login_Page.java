package Pages;

import Config.Common;
import Config.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

public class Compliance_Login_Page extends Abstract{

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();

    public Compliance_Login_Page(WebDriver driver) {
        this.driver=driver;
    }

    public void Enter_Login_Credentials(String UserName) throws IOException, org.json.simple.parser.ParseException{
        String Mail;
        if(UserName == "ComplianceOfficer") {
            Mail = common.read_json("ComplianceOfficerMail");
            common.isElementDisplayed(Mail);
            driver.findElement(By.xpath(ComplianceOfficerEmailField)).sendKeys(Mail);
            common.log("Step :: Enter "+UserName+" Email Address");
        }
        if(UserName == "TeamMember") {
            Mail = common.read_json("TeamMemberMail");
            common.isElementDisplayed(Mail);
            driver.findElement(By.xpath(ComplianceOfficerEmailField)).sendKeys(Mail);
            common.log("Step :: Enter "+UserName+" Email Address");
        }
        if(UserName == "Approver") {
            Mail = common.read_json("ApproverMail");
            common.isElementDisplayed(Mail);
            driver.findElement(By.xpath(ComplianceOfficerEmailField)).sendKeys(Mail);
            common.log("Step :: Enter "+UserName+" Email Address");
        }

        String Password = common.read_json("UserPassword");
        common.isElementDisplayed(ComplianceOfficerPasswordField);
        driver.findElement(By.xpath(ComplianceOfficerPasswordField)).sendKeys(Password);
        common.log("Step :: Enter Password ");
    }

    public void Verify_Login(){
        common.isElementDisplayed(SubmitButton_Login);
        driver.findElement(By.xpath(SubmitButton_Login)).click();
        common.log("Step :: Click on Login button");
        if(common.isDisplayed(Tasks_Header) == true){common.log("Step :: User Is Successfully Logged In");}
    }

    public void Go_To_Login_Page(){
        common.pause(30);
        common.isElementDisplayed(LoginButton);
        driver.findElement(By.xpath(LoginButton)).click();
        common.log("Step :: Click on Login button");
    }

    public void Verify_Login_With_Valid_Compliance_Officer_Credentials() throws AWTException, IOException, ParseException, org.json.simple.parser.ParseException {
        Go_To_Login_Page();
        Enter_Login_Credentials("ComplianceOfficer");
        Verify_Login();
    }

    public void Verify_Login_With_Valid_Team_Member_Credentials() throws IOException, ParseException, org.json.simple.parser.ParseException {
        Go_To_Login_Page();
        Enter_Login_Credentials("TeamMember");
        Verify_Login();
    }

    public void Verify_Login_With_Valid_Approver_Credentials() throws IOException, ParseException, org.json.simple.parser.ParseException {
        Go_To_Login_Page();
        Enter_Login_Credentials("Approver");
        Verify_Login();
    }

}
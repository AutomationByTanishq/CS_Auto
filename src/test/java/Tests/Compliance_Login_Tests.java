package Tests;

import Config.Configuration;
import Pages.Compliance_Login_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Compliance_Login_Tests extends Configuration{

    //1
    @Test
    public void Verify_Login_With_Valid_Compliance_Officer_Credentials() throws IOException, ParseException, AWTException {
        compliance_login_page.Verify_Login_With_Valid_Compliance_Officer_Credentials();
    }

    //2
    @Test
    public void Verify_Login_With_Valid_Team_Member_Credentials() throws IOException, ParseException, AWTException {
        compliance_login_page.Verify_Login_With_Valid_Team_Member_Credentials();
    }

    //3
    @Test
    public void Verify_Login_With_Valid_Approver_Credentials() throws IOException, ParseException, AWTException {
        compliance_login_page.Verify_Login_With_Valid_Approver_Credentials();
    }

}
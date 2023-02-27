package testrunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;

    @Test(priority = 1, description = "User can do login successfully")
    public void doLogin() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        JSONObject userObject= Utils.loadJSONFile("./src/test/resources/User.json");


        String username= (String) userObject.get("Username");
        String password= (String) userObject.get("Password");

        loginPage.doLogin(username, password);


    }
}
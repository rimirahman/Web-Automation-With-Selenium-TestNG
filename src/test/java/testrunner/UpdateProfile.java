package testrunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class UpdateProfile extends Setup {
    PIMPage pimPage;
    LoginPage loginPage;
    @Test(priority = 9, description = "login with Second user")
    public void loginWithUser2() throws IOException, ParseException, InterruptedException {
        String file = "./src/test/resources/employee.json";

        List employees = Utils.readJsondata(file);

        pimPage = new PIMPage(driver);
        JSONObject employeeObject1 = (JSONObject) employees.get(employees.size() - 2);
        String user2 = (String) employeeObject1.get("username");
        String password2 = (String) employeeObject1.get("password");

        loginPage = new LoginPage(driver);

        loginPage.doLogin(user2,password2);
    }

    @Test(priority = 10, description = "Click on My info menu")
    public void clickOnInfoMenu() throws InterruptedException {
        pimPage = new PIMPage(driver);
        Thread.sleep(5000);
        //pimPage.myInfo.get(2).click();
        pimPage.myInfo.get(2).click();
    }
    @Test(priority = 11, description = "Add gender")
    public void addGender() throws InterruptedException {
        pimPage = new PIMPage(driver);
        Thread.sleep(7000);
        pimPage.genderRadiobtn.get(1).click();
        Thread.sleep(7000);
        pimPage.savebutton.get(1).click();
    }
    @Test(priority = 12, description = "Add blood group")
    public void addBloodgroup() throws InterruptedException {
        pimPage = new PIMPage(driver);
        Thread.sleep(5000);
        //pimPage.bloodSelect.get(2).click();
        pimPage.bloodSelect.get(2).click();
        Thread.sleep(7000);
        pimPage.bloodSelect.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        pimPage.bloodSelect.get(2).sendKeys(Keys.ARROW_DOWN);
        pimPage.bloodSelect.get(2).sendKeys(Keys.ENTER);
        pimPage.savebutton.get(1).click();

    }

    @Test(priority = 13, description = "Add contact details")
    public void contactInfo() throws InterruptedException {
        pimPage = new PIMPage(driver);
        Thread.sleep(7000);
        Utils.doScroll(driver,-700);
        driver.findElement(By.xpath("//a[contains(text(),'Contact Details')]")).click();
        //pimPage.clickContact.get(1).click();
        Thread.sleep(3000);
        pimPage.txtInput.get(3).sendKeys("Dhaka");
        pimPage.txtInput.get(4).sendKeys("Badda");
        pimPage.txtInput.get(9).sendKeys("test1@usermail.com");
        Utils.doScroll(driver,700);
        Thread.sleep(3000);
        pimPage.savebutton.get(0).click();
    }

    @Test(priority = 14, description = "logout from second user")
    public void logoutFromUser() throws InterruptedException {
        pimPage = new PIMPage(driver);
        pimPage.dropdown.get(0).click();
        Thread.sleep(5000);
        pimPage.logOutbtn.get(3).click();
        Thread.sleep(5000);

    }
}

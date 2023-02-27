package testrunner;

import com.github.javafaker.Faker;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class PIMTestrunner extends Setup {

    LoginPage loginPage;
    PIMPage pimPage;

    @BeforeTest
    public void doLogin() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        //loginPage = new pages.LoginPage(driver);
        JSONObject userObject= Utils.loadJSONFile("./src/test/resources/User.json");


        String username= (String) userObject.get("Username");
        String password= (String) userObject.get("Password");

        loginPage.doLogin(username, password);
    }



//    @Test(priority = 1, description = "Check if user is Exist or not")
//    public void checkIfUserExist() throws IOException, ParseException, InterruptedException {
//        pimPage = new pages.PIMPage(driver);
//        pimPage.pim.get(1).click();
//        pimPage.savebutton.get(2).click();
//        Thread.sleep(3000);
//        pimPage.toggleButton.click();
//        List employee = utils.Utils.readJsondata("./src/test/resources/employee.json");
//        JSONObject userObj = (JSONObject) employee.get(employee.size() - 1);
//        String existingUserName = (String) userObj.get("userName");
//        Thread.sleep(1000);
//        String validationMessageActual = pimPage.checkIfUserExist(existingUserName);
//        String validationMessageExpected = "Username already exists";
//
//        Assert.assertTrue(validationMessageActual.contains(validationMessageExpected));
//        Thread.sleep(1000);
//    }


    @Test(priority = 2, description = "Create Employee")
    public void addEmployee() throws InterruptedException, IOException, ParseException {

        pimPage = new PIMPage(driver);
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = "Emp" + Utils.generateRandomNumber(1000, 9999);//pass through method so don't needed
        String password = "Password@1234";
        String employeeId = "0221";
        Thread.sleep(3000);


        pimPage.createEmployee(firstName, lastName, username, password);

        Utils.addJsonArray(firstName, lastName, username, password,employeeId);

    }

    @Test(priority = 3, description = "Searching With Invalid username")
    public void searchInvalidEmpUserName() throws InterruptedException, IOException, ParseException {
        String file = "./src/test/resources/employee.json";

        List employees = Utils.readJsondata(file);

        pimPage = new PIMPage(driver);
        JSONObject employeeObject1 = (JSONObject) employees.get(employees.size() - 1);
        String employeeusername1 = (String) employeeObject1.get("username");
        pimPage.searchEmployeeByfirstUserName(employeeusername1);
        Thread.sleep(5000);


        //Assertion
        String DataActual = pimPage.AssertSearch.get(17).getText();
        String DataExpected = "No Records Found";
        Thread.sleep(1000);
        Assert.assertTrue(DataActual.contains(DataExpected));
        Thread.sleep(1000);

    }

    @Test(priority = 4, description = "Searching with Valid username")
    public void searchEmployeeByfirstUserName() throws IOException, ParseException, InterruptedException {

        String file = "./src/test/resources/employee.json";

        List employees = Utils.readJsondata(file);

        pimPage = new PIMPage(driver);
        JSONObject employeeObject1 = (JSONObject) employees.get(employees.size() - 1);
        String employeeusername1 = (String) employeeObject1.get("username");
        pimPage.searchEmployeeByfirstUserName(employeeusername1);
        Thread.sleep(5000);


        //Assertion
//        String Actualfound = pimPage.AssertSearch.get(12).getText();
//        String Expectedfound = employeeObject1.get("firstName") + " "+ employeeObject1.get("lastName");
//        Assert.assertTrue(Actualfound.contains(Expectedfound));
//        Thread.sleep(1000);
    }

    @Test(priority = 5, description = "Search user from search table")
    public void usersearchfromSearchTable() throws IOException, ParseException, InterruptedException {

        String file = "./src/test/resources/employee.json";

        List employees = Utils.readJsondata(file);

        pimPage = new PIMPage(driver);
        JSONObject employeeObject1 = (JSONObject) employees.get(employees.size() - 1);
        String employeeusername1 = (String) employeeObject1.get("username");
        Thread.sleep(7000);
        pimPage.usersearchfromSearchTable(employeeusername1);
        //pimPage.usersearchfromSearchTable(employeeusername1);
        Thread.sleep(5000);

    }

    @Test(priority = 6, description = "update user with random user ID" )
    public void updateUserId() throws InterruptedException, IOException, ParseException {
        Utils utils = new Utils();

        String randomEmployeeId = String.valueOf(Utils.generateRandomNumber(1000, 9999));
        Thread.sleep(3000);
        //PIMPage.txtInput.get(5).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        PIMPage.txtInput.get(5).sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        String employeeId1 = randomEmployeeId;
        pimPage.updateUserId(employeeId1);
        Thread.sleep(7000);

       // Utils.updateJSONList(0,employeeId1,employeeId1);
        Utils.updateJSONList(0,employeeId1,employeeId1);

    }

    @Test(priority = 7, description = "Searching with Valid userId")
    public void searchByEmployeeId() throws IOException, ParseException, InterruptedException {

        String file = "./src/test/resources/employee.json";

        List employees = Utils.readJsondata(file);

        pimPage = new PIMPage(driver);
        JSONObject employeeObject1 = (JSONObject) employees.get(employees.size() - 1);
        String employeeId1 = (String) employeeObject1.get("employeeId");
        pimPage.searchByEmployeeId(employeeId1);
        //pimPage.searchByEmployeeId(employeeId1);
        Thread.sleep(5000);


    //Assertion
//        Thread.sleep(7000);
//        String header_actual=pimPage.headerTitle.get(0).getText();
//        String header_expected="Personal Details";
//        Assert.assertTrue(header_actual.contains(header_expected));


    }

    @Test(priority = 8, description = "logout from Admin")
    public void logoutFromAdmin() throws InterruptedException {
        pimPage = new PIMPage(driver);
        pimPage.dropdown.get(0).click();
        Thread.sleep(5000);
        pimPage.logOutbtn.get(3).click();
        Thread.sleep(5000);

    }


}





package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {
    @FindBy(className = "oxd-text")
    public List<WebElement> pim;

    @FindBy(className = "oxd-topbar-body-nav-tab-item")
    public List<WebElement> addEmployee;

    @FindBy(className = "oxd-button--secondary")
    public
    List<WebElement> savebutton;

    @FindBy(name = "firstName")
    WebElement txtFirstName;

    @FindBy(name = "lastName")
    WebElement txtLastName;

    @FindBy (tagName = "input")
    public static
    List<WebElement> txtInput;

    @FindBy(css = "[type=submit]")
    WebElement btnSubmit;

    @FindBy(className = "oxd-switch-input")
    public WebElement toggleButton;

    @FindBy(className = "orangehrm-main-title")
    public List<WebElement> headerTitle;

    @FindBy(className = "oxd-input")
    public List<WebElement> searchById;


    @FindBy(className = "oxd-input-field-error-message")
    public WebElement lblValidationError;

    @FindBy(className = "oxd-text")
    public List<WebElement> AssertSearch;

    @FindBy(className = "orangehrm-left-space")
    List<WebElement> searchbutton;

//    @FindBy(className = "bi-pencil-fill")
//    //public List<WebElement>editButton;
//    public List<WebElement>editButton;

    @FindBy(className ="oxd-icon")
    public List<WebElement>editbtn;

    @FindBy(className = "oxd-userdropdown")
    public List<WebElement>dropdown;

    @FindBy(className = "oxd-userdropdown-link")
    public List<WebElement>logOutbtn;

    @FindBy(className = "oxd-main-menu-item--name")
    public List<WebElement>myInfo;

    @FindBy(className = "oxd-radio-input")
    public List<WebElement>genderRadiobtn;

    @FindBy(className = "bi-caret-down-fill")
    public List<WebElement>bloodArrow;

    @FindBy(className = "oxd-select-text-input")
    public List<WebElement>bloodSelect;

    @FindBy(linkText = "Contact Details")
    //public List<WebElement>clickContact;
    public List<WebElement>clickContact;
    public PIMPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void createEmployee(String firstName,String lastName,String username,String password) throws InterruptedException {
        pim.get(1).click();

        addEmployee.get(2).click();

            txtFirstName.sendKeys(firstName);
            txtLastName.sendKeys(lastName);
            Thread.sleep(3000);
            toggleButton.click();
            savebutton.get(0).click();

            txtInput.get(7).sendKeys(username);//Input username
            txtInput.get(10).sendKeys(password);//Input password
            txtInput.get(11).sendKeys(password);//confirm password

            btnSubmit.click();
            Thread.sleep(5000);
    }

    public void searchEmployeeByfirstUserName(String username) throws InterruptedException {
        txtInput.get(1).sendKeys(username);
        Thread.sleep(3000);
        btnSubmit.click();
    }
//
    public String checkIfUserExist(String username){
        txtInput.get(5).sendKeys(username);
        return lblValidationError.getText();
    }

    public void usersearchfromSearchTable(String username) throws InterruptedException {
        pim.get(1).click();
        txtInput.get(1).sendKeys(username);
        Thread.sleep(7000);
        searchbutton.get(0).click();
        //searchbutton.get(0).click();

        Thread.sleep(5000);
        editbtn.get(24).click();
        //editButton.get(1).click();
        Thread.sleep(2000);

    }

    public void updateUserId(String employeeId) throws InterruptedException {
        txtInput.get(5).sendKeys(employeeId);
        savebutton.get(0).click();
        Thread.sleep(3000);
    }

    public void searchByEmployeeId(String employeeId) throws InterruptedException {
        pim.get(1).click();
        searchById.get(1).sendKeys(employeeId);
        Thread.sleep(3000);
        btnSubmit.click();
    }

    public void addGenderAndBloodgroup(){
         bloodArrow.get(2).click();
          var a = bloodArrow.get(2);
}


}

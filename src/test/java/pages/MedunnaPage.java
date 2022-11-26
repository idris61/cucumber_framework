package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaPage {

    public MedunnaPage(){
        PageFactory.initElements(Driver.getDriver(),this); // PageFactory den initElements methodunu kullanarak
                                                                // driver'ı bu sayfaya getiriyoruz
    }
    @FindBy(id = "account-menu")
    public WebElement accountMenu;

    @FindBy(id = "login-item")
    public WebElement signIn;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement signIn2;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu2;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement singOut;


    //-----------------------------------//

    @FindBy(xpath = "//span[text()='Administration']")
    public WebElement administration;

    @FindBy(xpath = "//span[text()='User management']")
    public WebElement userManagement;

    @FindBy(xpath = "//span[text()='Create a new user']")
    public WebElement createANewUser;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement login;

    @FindBy(xpath = "//select[@id='langKey']")
    public WebElement languageDdm;

    @FindBy(xpath = "//select[@id='authorities']")
    public WebElement profilesDdm;

    //-------------------------------------------//

    @FindBy (xpath = "//*[text()='»»']")
    public WebElement lastPageItem;

    @FindBy(xpath = "//*[text()='610-61-6666']/following-sibling::td[8]/div/a[3]")
    public WebElement SSNDelete;

    @FindBy(xpath = "/html/body//*/div[3]/button[2]")
    public WebElement sonDelete;

    @FindBy (xpath = "//div[@class='Toastify__toast-body']")
    public WebElement deleteToastContainerText;
}

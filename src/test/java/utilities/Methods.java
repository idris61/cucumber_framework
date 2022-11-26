package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.MedunnaPage;

public class Methods {

    MedunnaPage medunna = new MedunnaPage();
    Actions action = new Actions(Driver.getDriver());


    public void adminGiris() {

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        medunna.accountMenu.click();
        medunna.signIn.click();
        medunna.userName.click();
        action.sendKeys(ConfigReader.getProperty("userNameAdmin"),
                Keys.TAB, ConfigReader.getProperty("passwordAdmin"), Keys.TAB, Keys.TAB, Keys.
                        TAB, Keys.TAB, Keys.ENTER).perform();
    }

    public void staffGiris() {

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        medunna.accountMenu.click();
        medunna.signIn.click();
        medunna.userName.click();
        action.sendKeys(ConfigReader.getProperty("userNameStaff"),
                Keys.TAB, ConfigReader.getProperty("passwordStaff"), Keys.TAB, Keys.TAB, Keys.
                        TAB, Keys.TAB, Keys.ENTER).perform();
    }

    public void patientGiris() {

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        medunna.accountMenu.click();
        medunna.signIn.click();
        medunna.userName.click();
        action.sendKeys(ConfigReader.getProperty("userNamePatient"),
                Keys.TAB, ConfigReader.getProperty("passwordPatient"), Keys.TAB, Keys.TAB, Keys.
                        TAB, Keys.TAB, Keys.ENTER).perform();

    }

    public void physicianGiris() {

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        medunna.accountMenu.click();
        medunna.signIn.click();
        medunna.userName.click();
        action.sendKeys(ConfigReader.getProperty("userNamePhysician"),
                Keys.TAB, ConfigReader.getProperty("passwordPhysician"), Keys.TAB, Keys.TAB, Keys.
                        TAB, Keys.TAB, Keys.ENTER).perform();
    }

    public void userGiris() {

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        medunna.accountMenu.click();
        medunna.signIn.click();
        medunna.userName.click();
        action.sendKeys(ConfigReader.getProperty("userNameUser"),
                Keys.TAB, ConfigReader.getProperty("passwordUser"), Keys.TAB, Keys.TAB, Keys.
                        TAB, Keys.TAB, Keys.ENTER).perform();
    }

    public void userOlusturma() {

        adminGiris();
        medunna.administration.click();
        medunna.userManagement.click();
        medunna.createANewUser.click();
        medunna.login.sendKeys("userdelete.team10");
        action.sendKeys(Keys.TAB).sendKeys("team10")
                .sendKeys(Keys.TAB).sendKeys("team10")
                .sendKeys(Keys.TAB).sendKeys("userdelete.team10@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("610-61-6666")
                .sendKeys(Keys.TAB).perform();
        ReausableMethods.select(medunna.languageDdm).selectByIndex(1);
        action.sendKeys(Keys.ENTER).sendKeys(Keys.TAB).perform();
        ReausableMethods.select(medunna.profilesDdm).selectByIndex(1);
        action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        ReausableMethods.waitFor(3);
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

    }
}
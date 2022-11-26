package stepDefinitions.UISteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.MedunnaPage;
import utilities.Driver;
import utilities.Methods;
import utilities.ReausableMethods;

public class Kullanici_Girisleri_StepDefination {


    MedunnaPage medunnaPage = new MedunnaPage();
    Methods Methods = new Methods();

    @Given("User girisi yapilir")
    public void user_girisi_yapilir() {

        Methods.userGiris();
    }

    @Given("Personel girisi yapilir")
    public void personel_girisi_yapilir() {

        Methods.staffGiris();
    }

    @Given("Hasta girisi yapilir")
    public void hasta_girisi_yapilir() {

        Methods.patientGiris();
    }

    @Given("Doktor girisi yapilir")
    public void doktor_girisi_yapilir() {

        Methods.physicianGiris();
    }

    @Given("Admin girisi yapilir")
    public void admin_girisi_yapilir() {

        Methods.adminGiris();
    }

    @Given("Olusturulacak User bilgileri girilir")
    public void olusturulacakUserBilgileriGirilir() {

        Methods.userOlusturma();
    }

    @Then("IG Sign out butonuna tiklanir")
    public void igSignOutButonunaTiklanir() {

        medunnaPage.accountMenu2.click();
        ReausableMethods.waitFor(3);
        medunnaPage.singOut.click();
        ReausableMethods.waitFor(3);
    }
    @And("IG Sayfa kapatilir")
    public void igSayfaKapatilir() {

        Driver.closeDriver();
    }
}

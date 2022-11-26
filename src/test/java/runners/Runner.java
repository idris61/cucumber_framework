package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-reports.html", // sadece runer dan çalıştırdığımızda bu plugin raporu verir
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features", // feature dosyalarının yolunu string yazarız.
        glue = "stepDefinitions", // java kodlarını stepDefinitions dan alacak
        tags ="@US_010/TC_001",     // iki tag'ı aynı anda çalıştırmak isterseniz "@gp1 or @gp2"
        dryRun = true
)


public class Runner {

}

    /*
    Runner Class'ı TestNg deki XML mantığı ile çalışır. Çalıştırmak istediğimiz senaryolara tag belirtiriz ve
    belirttiğimiz tagları çalıştırır. XML deki gibi istediğimiz testleri çalıştırmak için kullanırız.
    Runner class body'si boştur ve runner class'ını ekleyeceğimiz notasyonlar aktive eder.
    Bu class'ta kullanacağımız 2 adet notasyon vardır.

        - @RunWith(Cucumber.class) notasyonu Runner Class'ına çalışma özelliği katar.
          Bu notasyon olduğu için Cucumber frameworkumüzde JUnit kullanmayı tercih ederiz.

        - @CucumberOptions notasyonu için de
          features : Runner dosyasının feature dosyasını nereden bulacağını tarif eder.
          glue : stepDefinitions dosyalarını nerede bulacağımızı gösterir
          tags : o an hangi tag'ı çalıştırmak istiyorsak onu belli eder

          dryRun : iki seçenek vardır
          dryRun = true  ==> dersek testimizi çalıştırmadan eksik adımları bize verir.
          dryRun = false ==> dersek testlerimizi driver ile çalıştırır.
     */
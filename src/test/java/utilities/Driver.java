package utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Driver { // İSTEDİĞİMİZ ZAMAN DRIVER'I GETİRECEK, İSTEDİĞİMİZ ZAMAN DRIVER'I KAPATACAK.

    private Driver(){ // Default constructor'u devre dısı bırakmak yani SingletonPattern yapmak icin kullanılıyor
                      // ve de kimse buna erisemesin, dolayisiyla da obje uretemesin diye access modifier'ini private yaptik
                      // artik kimmse Drievr class'indan obje uretemez !!!!!

    }
    static WebDriver driver; // static olmalı, cunku getDriver() ve closeDriver() methodu static
    private static int timeout = 5;

    public static WebDriver getDriver(){ // Bu method bize; driver class'ından getDriver'i çağırdığımızda bize driver'ı getirecek.
                                         // void yapmıyoruz cunku biz driver ile methodlari çalıştıracağız. Bize driver
                                         // dondurmesi lazim ki, getDriver() methodundan sonra driver methodlarina ulasabilelim

        if (driver == null){ // burda driverin değeri null ise yani driver açık değilse bize driveri açsın,çalıştırsın

            switch (ConfigReader.getProperty("browser")){ // configuration.properties deki "browser"'ın karşılığındaki değer
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "headless-chrome": // arka planda çalışıp, sonucu döndürüyor.
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }
         // eger driver'a daha onceden deger atanmamissa, ona new keyword'u ile deger ata,
         // deger atanmis ise dokunma demek
         // boyle yapmazsak methodu yani driver'i her cagirdigimizda yeni bir driver olusmus olur ve
         // islemlerimizi akici sekilde yaptiramayiz
         /*
         Driver.getDriver method'u her calistiginda
         // driver=new ChromeDriver(); komutundan dolayi yeni bir driver olusturuyor
         // Biz Driver class'dan getDriver'i calsitirdigimizda new atamasi olsun
         // sonraki calistirmalarda atama olmasin istiyoruz
         // bunun icin driver= new ChromeDriver(); satiri bir if blogu iicine alacagiz
          */
    public static void closeDriver(){
        if(driver != null){
            driver.close();
            driver = null;
        }
        // olusturuken kullandigimiz null mi degil mi kontrolunu burada da kullanmamiz gerekiyor
        // yoksa pes pese calisan testlerde her test sonunda kapatma methodunu kullanirsam,
        // ikinci method driver'i bulamaz, cunku driver null degil, atamasi yapildi ve kapatildi
        // yani kapatilmis olsa da driver'a bu class icerisinde atama yapilmis, dolayisiyla ben
        // 2. test methodunda calistirdigimda new keyword'u kullanilmiyor, eski driver kullanilmaya devam ediliyor
        // ancak onu da kapattigimiz icin 2. test methodunda driver islevsiz hale geliyor
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }


 /*
  *** POM'de Driver için TestBase class'ina extends etmek yerine
      Driver class'indan static method'lar kullanarak driver oluşturup,
      ilgili ayarların yapılması ve en sonda driver'in kapatılması tercih edilmiştir.

  *** Testlerimizi çalıştırdığımızda her seferinde yeni driver oluşturduğu için her test methodu
      için yeni bir pencere(driver) açıyor. Eğer driver'a bir değer atanmamışsa yani driver==null ise
      bir kere driver'i çalıştır diyerek bir kere if içini çalıştıracak. Ve driver artık bir kere
      çalıştığı için ve değer atandığı için null olmayacak ve direk return edecek ve diğer
      teslerimiz aynı pencere(driver) üzerinde çalışacak

  *** POM'da Driver classindaki getDriver() ile obje olusturularak kullanilmasini
      engellemek icin Singleton pattern kullanimi benimsemistir.

      Singleton Pattern: tekli kullanim, bir class'in farkli classlardan
      obje olusturularak kullanimi engellemk icin kullanilir.
      bunu yapmamiz icin; obje olusturmak icin kullanilan constructor'i private yaptigimiz zaman
      baska classlardan Driver classindan obje olusturulmasi mumkun olamaz.

  *** Temel mantığımız şu; artık extends ile değil,
      Driver class'ındaki static methodlarla driver'ı kullanmak açmak/kapatmak istiyoruz.
      Açmak için daha önce TestBase de yaptığımız setup methodunu, kapatmak için de daha önce TestBase de yaptığımız
      tearDown ı koyduk.

      Burada şöyle bir problem var; biz her driver kullanmak istediğimizde getDriver() methodunu çağırıyoruz, dolayısıyla
      driver = new ChromeDriver(); dediği için her seferinde yeni bir pencere açılıyor.
      Bunun önüne geçebilmek için; if ile, daha önceden driver'a new ChromeDriver atanmışsa bir daha atamasın,
      atanmamışsa o zaman var olan driver'ı döndür dedik.
  */

 public static void waitAndClick(WebElement element, int timeout) {
     for (int i = 0; i < timeout; i++) {
         try {
             element.click();
             return;
         } catch (WebDriverException e) {
             wait(1);
         }
     }
 }
    public static void waitAndClick(WebElement element) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndSendText(WebElement element, String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    //    Driver.waitANdSendText(Element , "TEXT");
    public static void waitAndSendText(WebElement element, String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndSendTextWithDefaultTime(WebElement element, String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static String waitAndGetText(WebElement element, int timeout) {
        String text = "";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
        return null;
    }
    //Webdriver
    //ChromeDriver
    //Iedriver
    //FirefoxDriver
    public static void wait2(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //5 seconds
    public static void waitAndClickElement(WebElement element, int seconds) {
        for (int i = 0; i < seconds; i++) {
            try {
                element.click();
                break;
            } catch (Exception e) {
                wait2(1);
            }
        }
    }
    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static Boolean waitForInVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }
    public static void selectAnItemFromDropdown(WebElement item, String selectableItem) {
        wait(5);
        Select select = new Select(item);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(selectableItem)) {
                select.getOptions().get(i).click();
                break;
            }
        }
    }
    public static void selectAnRandomItemFromDropdown(WebElement item) {
        // wait(5);
        Select select = new Select(item);
        int rastgeleSayi = (int)(Math.random() * select.getOptions().size());
        select.getOptions().get(rastgeleSayi).click();
    }
    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
    /**
     * Clicks on an element using JavaScript
     *
     * @param elements
     */
    public static void clickWithJSAsList(List<WebElement> elements) {
        for (WebElement each : elements) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(each, 5));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", each);
        }
    }
    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }
    //    Parameter1 : WebElement
//    Parameter2:  String
//    Driver.selectByVisibleText(dropdown element, "CHECKING-91303-116.98$")
    public static void selectByVisibleText(WebElement element, String text) {
        Select objSelect = new Select(element);
        objSelect.selectByVisibleText(text);
    }
    //    Parameter1 : WebElement
//    Parameter2:  int
//    Driver.selectByIndex(dropdown element, 1)
    public static void selectByIndex(WebElement element, int index) {
        Select objSelect = new Select(element);
        objSelect.selectByIndex(index);
    }
    //    Parameter1 : WebElement
//    Parameter2:  String
//    Driver.selectByIndex(dropdown element, "91303")
    public static void selectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        List<WebElement> elementCount = objSelect.getOptions();
        objSelect.selectByValue(value);
        System.out.println("number of elements: " + elementCount.size());
    }
    public static void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void waitAndClickLocationText(WebElement element, String value) {
        Driver.getDriver().findElement(By.xpath("//*[text()='" + value + "']")).click();
    }
}
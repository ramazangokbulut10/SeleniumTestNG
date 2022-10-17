package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    // Bu class driverleri yönetmek için yapıldı.

    /*
    POM'de Driver icin TestBase class'ina extends etmek yerine
    Driver class'indan static method'lar kullanarak
    driver olusturup, ilgili ayarlarin yapilmasi
    ve en sonda driver'in kapatilmasi tercih edilmistir.

    POM'de Driver class'indaki getDriver()'in obje olusturularak kullanilmasini
    engellemek icin
    Singleton pattern kullanimi benimsenmistir

    Singleton Pattern : tekli kullanim, bir class'in farkli class'lardan
                        obje olusturarak kullanimini engellemek icin kullanilir

    Bunu saglamak icin yapmamiz gereken sey oldukca basit
    obje olusturmak icin kullanilan constructor'i private yaptiginizda
    baska class'larda Driver class'indan obje olusturulmasi mumkun OLMAZ
     */

    // HER ZAMAN KULLANABİLECEGİMİZ HAZİR SABLON

     private Driver(){ // tekli kullanim, bir class'in farkli class'lardan
                      // obje olusturarak kullanimini engellemek icin kullanilir

      }
     static WebDriver driver; // Driveri'de hem açma,hem kapatma methodlarında kullanmak için burda oluşturduk.

    public static WebDriver getDriver(){

        if (driver==null) { // Daha önce drivere değer atanmamışsa bu işle  mi yap dedik.
            switch (ConfigReader.getProperty("browser")){

                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(); // sürekli yeni browser açıyor bu kod ile.
                    break;

                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;

                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
     return driver;
    }

    public static void closeDriver(){
        if(driver!=null) { // Driver'a değer atanmışsa
            driver.close();
            driver=null;
        }
    }
}

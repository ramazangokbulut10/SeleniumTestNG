package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class  CrossDriver {

    //BU classı xml ile baglanti kurup istedigimiz browser da calistirabilmek icn duzenledik

    private CrossDriver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver(String browser){

        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        if (driver==null) {
            switch (browser){

                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
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
        }
        return driver;
    }

    public static void closeDriver() {

        if(driver!=null) {
            driver.close();
            driver=null;
        }
    }
}

package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    // abstract yapmamizin sebebi bu class'dan obje olusturulmasinin onune gecmektir

    // @BeforeMethod ve @AfterMethod notasyonlari

    // JUnit'deki @Before ve @After gibidir

    // her test method'undan once ve sonra calisirlar

    // PageObjectModel'den önce, kullandığımız yöntem için ayarlamıştık, Extends yaparak kullanırdık :)

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterMethod
    public void tearDown(){
         driver.quit();
    }
}

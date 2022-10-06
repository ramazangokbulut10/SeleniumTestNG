package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C04_DependsOnMethods {

    /*
    DependsOnMethods test method'larinin calisma siralamasina karismaz
    Sadece bagli olan test, baglandigi testin sonucuna bakar
    baglandigi test PASSED olmazsa, baglanan test hic calismaz(ignore)
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test1() {
// AMAZON ANASAYFAYA GIDELIM
        driver.get("https://amazon.com");

    }

    @Test (dependsOnMethods = "test1") // testimizin çalismasinin hangi method a bagli oldugunu gösteriyor
    public void test2() {
//NUTELLA ARATALIM
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
    }



    @Test (dependsOnMethods = "test2")
    public void test3() {
 //SONUC YAZISININ NUTELLA ICERDIGINI TEST EDELIM

    WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));

    }

    @Test (groups = {"grup1","grup2"})
    public void test04() {
        System.out.println("bak bu calisti");
    }
}

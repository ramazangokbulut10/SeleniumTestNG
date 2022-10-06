package tests.day22_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_SoftAssertCross extends TestBase {


    @Test
    public void test01() {



        // softAssert BASLANGICI OBJE OLUSTURMAKTIR  ***********************
        SoftAssert softAssert = new SoftAssert();

        // 1-amazon anasayfaya gidin
        driver.get("https://amazon.com");

        // 2-Title'in Amazon icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");

        // 3- Arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(),"arama kutusuna erisilemiyor");

        // 4- Arama kutusunda nutella yazip aratin
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // 5- Arama yapildigini test edin
        WebElement sonucYaziElementi =
                driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(),"arama yapilamadi");

        // 6- Arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Nutella"),"sonuc yazisi Kutella icermiyor");

        // softAssert'e BITIS SATIRINI SOYLEMEK ICIN assertAll() KULLANILIR *********************
        // bu satir yazilmazsa assertion gorevi yapilmamis olur

        softAssert.assertAll();

        System.out.println("assertion'lardan fail olan olursa, burasi calismaz");
                         // bu yazi tum assertionlar PASSED olursa calisir


    }
}

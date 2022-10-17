package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {


    @Test (groups = "grup2")
    public void test01() {

     // JUnitte Assertions'da hatayı bulunca kodu durdurup,direkt bize rapor veriyordu

     // SoftAssertions'da öyle değil, tüm kodları inceliyor, tüm hataları toplu söylüyor.

     /*
    Softassertion baslangic ve bitis satirlari arasindaki
    tum assertion'lari yapip
    bitis satirina geldiginde bize buldugu tum hatalari rapor eder

    Baslangici ve bitisi biz belirleriz
     */

        // softAssert BASLANGICI OBJE OLUSTURMAKTIR  ***********************
        SoftAssert softAssert = new SoftAssert();

        // 1-amazon anasayfaya gidin
        driver.get("https://amazon.com");

        // 2-Title'in Amazon icerdigini test edin
        String expectedTitle = "amazon";
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
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Kutella"),"sonuc yazisi Kutella icermiyor");
        // obje adı ile kontrol ederiz.

        // softAssert'e BITIS SATIRINI SOYLEMEK ICIN assertAll() KULLANILIR *********************
        // bu satir yazilmazsa assertion gorevi yapilmamis olur

        softAssert.assertAll();

        System.out.println("assertion'lardan fail olan olursa, burasi calismaz");
                         // bu yazi tum assertionlar PASSED olursa calisir
        //  softAssert.assertAll(); methodunu yazdıktan sonra, junit özelliğine döner gibi olur,
        //  çünkü hatayı görür görmez çalıştırmayacak hale gelecek.

        /*
        Softassert'un hata bulsa bile calismaya devam etme ozelligi
        assertAll()'a kadardir

        Eger assertAll()'da failed rapor edilirse calisma durur
        ve class'in kalan kismi calistirilmaz
        (Yani assertAll hardAssert'deki her bir assert gibidir hatayi yakalarsa calisma durur)
         */

        /*
         birden fazla hata cikabilecegi icin
         hata mesajlarini da burada yanlarina yaziyoruz
         */

        /*
        HardAssertion : yani JUnit de kullandigimiz assertion
                        ilk hata aldiginda calismayi durdurup FAILED veriyor

        SoftAssertion : tum testler sonuna kadar calisiyor ve
                        en son hata aldigi yerlerin hepsini tek tek raporluyor
                        herhangi bir assertion FAILED olsa bile sonuna kadar
                        calismaya devam eder
         */

    }
}

package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestRaporlu extends TestBaseRapor { // Raporlama bilgilerine ulaşmak için, Extends yaptık.

    BrcPage brcPage = new BrcPage(); // Brc'nin locateleri ulaşmak için class seviyesinde oluşturduk.

   // BrcPage brcPage ;

    @Test
    public void test01() {
        // brcPage = new BrcPage(); Birden fazla test methodunda kullanacağımız zaman, yukarıda yorum satırındaki gibi

        // yapıp tekrare test01 methodunun içindeki gibi her methodda ayrı yapmalıyız.

        // Her test methoduna başlarken yazmak zorundayız 24.satırı.
        // arasına yazdığımız yazı,sayfanın üst kısmında görülecektir.
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve password ile giris yapabilmeli ");
        /* *** */

        // Bilgi verilmesini istediğimiz her adıma "extentTest.info" diyerek bilgi ekleriz.

        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi"); /* *** */

        //login butonuna tikla
        brcPage.ilkLoginButonu.click();
        extentTest.info("Login butonuna tiklandi"); /* *** */

        //user email : customer@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi"); /* *** */

        //password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli password yazidi"); /* *** */

        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        extentTest.info("Login butonuna tiklandi"); /* *** */

        //Degerleri girildiginde sayfaya gidildigini test et

        String actualUsername=brcPage.kullaniciProgfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername,expectedUsername);
        extentTest.pass("kullanici basarili sekilde giris yapti"); /* *** */
        Driver.closeDriver();

        // pass dediğimizde "yeşil tik" oluyor raporda
        // info dediğimizde "i" bilgisi çıkıyor.


        /*

        Tarayıcıda görmek istediğimizde dosya nereye kayıt ediliyorsa ora gidip bakarız, benimkisi

        target > dosya > html dosyasına sağ tıklayıp, open in browser seçerek bulabiliriz.

         */

    }
}

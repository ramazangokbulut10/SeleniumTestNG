package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PagesClassKullanimi {

    @Test
    public void test01() throws InterruptedException {

        FacebookPage facebookPage = new FacebookPage();

        //facebook a gidin
        Driver.getDriver().get("https://facebook.com");

        //cikarsa cookies kabul edin  // BENDE ÇIKMADİ

        //kullanici mail kutusuna rastgele bir isim yazdirin
         Faker faker = new Faker(); // rastgele bir e posta ve password girmek için faker oluşturduk.
         facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());

        //kullanici sifre kutusunsa rastgele bir password yazdirin
         facebookPage.sifreKutusu.sendKeys(faker.internet().password());

        //login butonuna basin
        facebookPage.loginTusu.click();

        //giris yapilamadigini test edin
        Thread.sleep(2000);
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
}

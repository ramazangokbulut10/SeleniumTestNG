package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void test01() {
        AmazonPage amazonPage = new AmazonPage(); // AmazonPage ulaşmak için obje oluşturduk.

        //amazona gidelim
        Driver.getDriver().get("https://amazon.com");

        //nutella aratalim
        amazonPage.aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        //sonuc yazisinin nutelle icerdigini test edelim
        String actualSonuc = amazonPage.aramaSonucuElementi.getText();
        String arananKelime = "nutella";

        Assert.assertTrue(actualSonuc.contains(arananKelime));
        Driver.closeDriver();
    }
}

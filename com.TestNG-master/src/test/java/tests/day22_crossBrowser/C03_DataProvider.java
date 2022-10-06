package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    @Test
    public void test01() {
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        String expectedKelime = "Nutella";
        String actualKelime = amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualKelime.contains(expectedKelime));

        Driver.closeDriver();
    }





    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArrayi={{"Nutella"},{"Java"},{"cigdem"},{"Netherlands"}};

        return arananKelimeArrayi;
    }



    @Test (dataProvider = "AranacakKelimeler") // once bunu olusturduk altini cizdi ustteki kısmı olusturduk
                                    /* arayacagimiz kelimeleri bir liste gibi tutup
                                     bana yollayacak bir veri saglayicisi olusturacagiz*/

    public void dataProviderTesti(String arananKelime) {

        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella, Java, cigdem ve Netherlands icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(arananKelime+ Keys.ENTER);

        // Sonuclarin aradigimiz kelime icerdigini test ederlim
        String expectedKelime = arananKelime;
        String actualKelime = amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        Driver.closeDriver();
    }
}

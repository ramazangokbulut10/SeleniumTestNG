package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {

    BrcPage brcPage;

    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri = {{"firuze@nehaber.com","54678"},
                                        {"murat@benbuisibilirim.com","65874"},
                                        {"ilyas@hollandadanselam.com","85967"}};
        return kullaniciBilgileri;
    }

    @Test (dataProvider = "kullaniciListesi")
    public void yanlisSifre(String userMail,String password) throws InterruptedException {
        brcPage = new BrcPage();
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //login butonuna tikla

        brcPage.ilkLoginButonu.click();

        //user email : dataProvider'dan alalim
        brcPage.emailTextBox.sendKeys(userMail);

        //password :dataProvider'dan alalim
        brcPage.passwordTextBox.sendKeys(userMail);

        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili bir sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed()); // hala 2.login butonu gorunuyorsa sayfaya giremedi
        Driver.closeDriver();

    }


}

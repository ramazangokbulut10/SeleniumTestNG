package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestRaporlu extends TestBaseRapor {

    BrcPage brcPage = new BrcPage();

    @Test
    public void test01() {

        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve password ile giris yapabilmeli ");
        /* *** */
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

    }
}

package tests.day21_reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.util.Set;

public class C01_WindowHandleReusableMethods {

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH = Driver.getDriver().getWindowHandle();
        // Click yapmadan önce ilk sayfanın handle'nı aldık.

        // Click Here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String> windowHandleSet = Driver.getDriver().getWindowHandles();

        String ikinciSayfaWH="";

        for (String each:windowHandleSet
             ) {
            if (!each.equals(ilkSayfaWH)){
                ikinciSayfaWH=each;
            }
          Driver.getDriver().switchTo().window(ikinciSayfaWH);
            System.out.println(Driver.getDriver().getTitle());
        }

        // ACİLAN YENİ TAB'İN TİTLE'İNİN "New Window" old test edin

        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();
    }

    @Test
    public void test02() {

        // ReusableMethods ile çözümü.

        //https://the-internet.herokuapp.com/windows adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        // Click Here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        // ACİLAN YENİ TAB'İN TİTLE'İNİN "New Window" old test edin
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();
    }


}

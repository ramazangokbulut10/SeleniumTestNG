package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {

    /*
    TestNG test method'larini isim sirasina gore calistirir
    eger isim siralamasinin disinda bir siralama ile calismasini isterseniz
    o zaman test method'larina oncelik (priority) tanimlayabiliriz

    priority kucukten buyuge gore calisir
    eger bir test method'una priority degeri atanmamissa
    defoult olarak priority=0 kabul edilir.
     */

    // priority'si kucuk olan ilk calisir

    @Test (priority=-5)
    public void amazonTesti() {
        driver.get("https://amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test (priority = -2)
    public void test02() {
        driver.get("https://bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test (groups = "grup1")
    public void techproedTesti() {
        driver.get("https://techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }
}

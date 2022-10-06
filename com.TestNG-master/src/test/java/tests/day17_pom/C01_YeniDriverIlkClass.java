package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {

    @Test (groups = "grup1")
    public void test1() {

        Driver.getDriver().get("https://amazon.com");

        /*
        Bugüne kadar TestBae class'ina extends ederek kullandigimiz driver yerine
        bundan sonra Driver classs'indan kullanacagimiz getDeriver static method'unu kullanacagiz

        Driver.getDriver()   in
        driver               out
         */

        Driver.closeDriver();
        Driver.getDriver().get("https://bestbuy.com");
        Driver.getDriver().get("https://facebook.com");

        Driver.closeDriver();
    }
}

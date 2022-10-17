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

        Driver.getDriver()   in  (Driver classından, getdriver methodunu çağırıyoruz sürekli)
        driver               out (extends ile yazdığımız driver)
         */

        Driver.closeDriver();
        /*
        TestBase'de extends yazarak tek bir sayfada tüm kodları çalıştırmak için, BeforeAfterClass Methodunu kullanıyorduk.
        Ama Driver'e(class) özel ayarlar yaptık, artık istediğimiz yerlerde açar istediğimiz yerlerde kapatırız,keyfimize kalmış.
        Yukarıda kapattık aşağıda tekrar açtık ve tekrar kapattık.
         */
        Driver.getDriver().get("https://bestbuy.com");
        Driver.getDriver().get("https://facebook.com");

        Driver.closeDriver();
    }
}

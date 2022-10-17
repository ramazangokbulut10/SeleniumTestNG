package tests.day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {

    // JUnit'de @BeforeClass ve @AfterClass notasyonuna sahip
    // method'lar static olmak ZORUNDAYDI
    // TestNg zorunlu değil.

    /*
    TestNG bize daha fazla before ve after notasyonlari sunar
    diger before/after notasyonlari tanimlayacagimiz grup,
    test veya sut'den once ve sonra calisirlar
    ileride xml dosyalari ile birlikte bunu gorecegiz
     */

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("After Class");
    }

    @Test
    public void amazonTesti() {
        driver.get("https://amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test02() {
        driver.get("https://bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void techproedTesti() {
        driver.get("https://techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }
}

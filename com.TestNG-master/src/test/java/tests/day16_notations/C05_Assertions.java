package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assertions extends TestBase {

    @Test
    public void test01() {

        // 1-amazon anasayfaya gidin
        driver.get("https://amazon.com");

        // 2-Title'in Amazon icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 3- Arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());

        // 4- Arama kutusunda nutella yazip aratin
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // 5- Arama yapildigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        // 6- Arama sonucunun Nutella icerdigini test edin
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));


    }
}

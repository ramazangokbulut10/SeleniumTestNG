package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage(){ // public bilerek yaptık her yerden ulaşalım diye. Constructor bu oluşturduğumuz şey.

        PageFactory.initElements(Driver.getDriver(),this);
        /*
        Constructor oluşturarak, Drivere bu şeye tanıttık. Eşleştirdik,tanıştırdık :)
         */
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucuElementi;
}

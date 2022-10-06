package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.Watchable;

public class FacebookPage {

    public FacebookPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="email")
    public WebElement mailKutusu;

    @FindBy(id="pass")
    public WebElement sifreKutusu;

    @FindBy(name="login")
    public WebElement loginTusu;

    @FindBy(className = "_9ay7")
    public WebElement girilemediYaziElementi;
}

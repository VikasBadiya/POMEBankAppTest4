package ObjectPages;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    //Define the locators for the Home page

    //Heading text
    By HeadingTextLocator = By.cssSelector("h1[class*='heading']");

    //App logo image
    By  AppLogoImageLocator = By.cssSelector("img[class*='ebank-logo']");

    //Digital card image

    By DigitalCardImageLocator = By.cssSelector("img[class*='digital-card-image']");

    //"Logout" button
    By LogoutButtonLocator = By.cssSelector("button[class*='logout-button']");

    //----------------------------------------------------------------------------

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Define the methods for performing actions on the elements
    //Get the text content of the Heading

    public String GetHomeHeadingText(){
        return driver.findElement(HeadingTextLocator).getText();
    }
    //Find the App logo image
    public WebElement FindAppLogoImage(){
        return driver.findElement(AppLogoImageLocator);
    }

    //Find the Digital card image
    public WebElement FindDigitalCardImage() {
        return  driver.findElement(DigitalCardImageLocator);
    }

    //Click the "Logout" button
    public void LogoutButton(){
        driver.findElement(LogoutButtonLocator).click();
    }






}

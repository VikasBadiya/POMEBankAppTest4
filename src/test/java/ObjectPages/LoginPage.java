package ObjectPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    //Define the locators for the Login page
    //Login image

    By LoginImageLocator = By.cssSelector("img[class*='login-ebank-image']");

    //List of Label texts

    By ListOfLabelTestsLocator = By.cssSelector("label[class*='input-label']");

    //Login heading

    By LoginHeadingLocator = By.cssSelector("h1[class*='login-heading']");

    //"User ID" input field

    By UserIdInputLocator = By.cssSelector("input[id*='userIdInput']");

    //"PIN" input field
    By PinInputLocator = By.cssSelector("input[id*='pinInput']");

    //"Login" button

    By LoginButtonLocator  = By.cssSelector("button[class*='login-button']");

    //Error Message ()

    By ErrorMessageLocator  = By.cssSelector("p[class*='error-message-text']");





    //______________________________________________________________________________________

    WebDriver driver;
    WebDriverWait wait;

    //Define the methods for performing actions on the elements
    //Find the Login image

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));


    }

    public WebElement FindLoginImage(){

        return driver.findElement(LoginImageLocator);
    }

    //Get the text content of the Login heading

    public String GetLoginHeading(){
        return driver.findElement(LoginHeadingLocator).getText();
    }

    //Get the text content of the label at a specified index

    public  String GetLabelText(int index){
        return driver.findElements(ListOfLabelTestsLocator).get(index).getText();
    }

    //Enter a text in the "User ID" input field

    private void UserIdInput(String UserId ){
         driver.findElement(UserIdInputLocator).sendKeys(UserId);

    }
    //Enter a text in the "PIN" input field

    private void PinInput(String Pin){
        driver.findElement(PinInputLocator).sendKeys(Pin); ;

    }

    //Click the "Login" button

    public void LoginButton(){
        driver.findElement(LoginButtonLocator).click();
    }
    //Enter with the given credentials and click the "Login" button
    public void givenCredentials(String UserId,String Pin){
        UserIdInput(UserId);
        PinInput(Pin);
        LoginButton();

    }

    //Wait and get the text content of the error message
    public String GetErrorMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageLocator)).getText();

    }


}

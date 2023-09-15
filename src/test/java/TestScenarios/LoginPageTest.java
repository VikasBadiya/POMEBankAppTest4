package TestScenarios;

import ObjectPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {
    LoginPage LPage;
    public WebDriver driver;





    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qaebank.ccbp.tech/ebank/login");
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }





    //Test the Login Page UI
    @Test(priority = 1)
    public void LoginPageUITest(){

        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        //Verify if the Login image is displayed - use Assertions,
        //If the Login image is not displayed, print "Login image is not displayed"

        Assert.assertTrue(LPage.FindLoginImage().isDisplayed(),"Login image is not displayed");

        //Verify the User ID label text - use Assertions,
        //Expected text: User ID
        //If the Label text does not match the expected text, print "User id label text does not match"

        Assert.assertEquals(LPage.GetLabelText(0),"User ID","User id label text does not match");

        //Verify the Pin label text - use Assertions,
        //Expected text: PIN
        //If the Label text does not match the expected text, print "Pin label text does not match"

        Assert.assertEquals(LPage.GetLabelText(1),"PIN","Pin label text does not match");

        //Verify the Heading text of the Login page - use Assertions,
        //Expected text: Welcome Back!
        //If the Heading text does not match the expected text, print "Heading text does not match"

        Assert.assertEquals(LPage.GetLoginHeading(),"Welcome Back!","Heading text does not match");

    }

    //Test the submission with empty input fields

    @Test(priority = 2)
    public void SubmissionWithEmptyInput(){
        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        //Click the "Login" button.
        //Verify the error message - use Assertions,
        //Expected text: Invalid user ID
        //If the error message does not match the expected text, print "Error text with empty input fields does not match"
        //Close the browser window.
        LPage.LoginButton();

        Assert.assertEquals(LPage.GetErrorMessage(),"Invalid user ID","Error text with empty input fields does not match");

    }


//Test the submission with empty User ID field

    @Test(priority = 3)
    public void SubmissionWithEmptyUserId(){
        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        //Login to the application, only with the PIN 231225.
        //Verify the error message - use Assertions,
        //Expected text: Invalid user ID
        //If the error message does not match the expected text, print "Error text with empty input field do not match"
        //Close the browser window.

        LPage.givenCredentials("","231225");
        LPage.LoginButton();
        Assert.assertEquals(LPage.GetErrorMessage(),"Invalid user ID","Error text with empty input field do not match");

    }

    //Test the submission with empty PIN field
    @Test(priority = 4)
    public void SubmissionWithEmptyPIN(){
        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        //Login to the application, only with the User ID 142420.
        //Verify the error message - use Assertions,
        //Expected text: Invalid PIN
        //If the error message does not match the expected text, print "Error text with empty input field do not match"
        //Close the browser window.
        LPage.givenCredentials("142420","");
        LPage.LoginButton();
        Assert.assertEquals(LPage.GetErrorMessage(),"Invalid PIN","Error text with empty input field do not match");

    }

    //Test the submission with invalid PIN
    @Test(priority = 5)
    public void SubmissionWithInvalidPin(){
        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        //Login to the application, with the User ID 142420 and PIN 123456.
        //Verify the error message - use Assertions,
        //Expected text: User ID and PIN didn't match
        //If the error message does not match the expected text, print "Error text with invalid PIN do not match"
        //Close the browser window.
        LPage.givenCredentials("142420","123456");
        LPage.LoginButton();
        Assert.assertEquals(LPage.GetErrorMessage(),"User ID and PIN didn't match","Error text with invalid PIN do not match");
    }

    //Test the successful login

    @Test(priority = 6)
    public void SubmissionWithValidInput(){
        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        //Login to the application, with the User ID 142420 and PIN 231225.
        //Wait and verify the navigation to the home page - use Assertions,
        //Expected URL: https://qaebank.ccbp.tech/
        //If the current URL does not match the expected URL, print "URLs do not match"
        //Close the browser window.

        LPage.givenCredentials("142420","231225");
        LPage.LoginButton();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaebank.ccbp.tech/","URLs do not match");


    }





}

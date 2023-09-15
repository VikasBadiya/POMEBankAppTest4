package TestScenarios;

import ObjectPages.HomePage;
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

public class HomePageTest {
    LoginPage LPage;
    HomePage HPage;
    public WebDriver driver;





    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LPage = new LoginPage(driver);
        HPage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qaebank.ccbp.tech/ebank/login");
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    //Test the Home page UI
    @Test(priority = 7)
    public void HomePageUI(){
        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        //Login to the application, with the User ID 142420 and PIN 231225.
        //Wait until the web driver navigates to the home page
        //Home Page URL: https://qaebank.ccbp.tech/
        //Verify if the App logo is displayed - use Assertions,
        //If the App logo is not displayed, print "App logo is not displayed"

        LPage.givenCredentials("142420","231225");
        LPage.LoginButton();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/"));
        Assert.assertTrue(HPage.FindAppLogoImage().isDisplayed(),"App logo is not displayed");

        //Verify the Heading text of the home page - use Assertions
        //Expected text: Your Flexibility, Our Excellence
        //If the Heading text does not match the expected text, print "Heading text does not match"

        Assert.assertEquals(HPage.GetHomeHeadingText(),"Your Flexibility, Our Excellence","Heading text does not match");

        //Verify if the Digital card image is displayed - use Assertions,
        //If the Digital card image is not displayed, print "Digital card image is not displayed"
        //Close the browser window.

        Assert.assertTrue(HPage.FindDigitalCardImage().isDisplayed(),"Digital card image is not displayed");

    }

    //Test the Logout functionality

    @Test(priority = 8)
    public void LogoutFunctionality(){

        //Navigate to the URL https://qaebank.ccbp.tech/ebank/login
        //Login to the application, with the User ID 142420 and PIN 231225.
        //Wait until the web driver navigates to the home page
        //Home Page URL: https://qaebank.ccbp.tech/
        LPage.givenCredentials("142420","231225");
        LPage.LoginButton();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/"));
        //Click the "Logout" button.
        HPage.LogoutButton();

        //Verify the navigation to the login page - use Assertions,
        //Expected URL: https://qaebank.ccbp.tech/ebank/login/
        //If the current URL does not match the expected URL, print "URLs do not match"
        //Close the browser window.
        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/ebank/login"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaebank.ccbp.tech/ebank/login","URLs do not match");
    }








}

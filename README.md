In this exercise, you will be automating the process of testing the EBank App using Page Object Model.

### Prerequisites

- Install IntelliJ IDEA Community IDE  Version 2018.3.6.
- Install OpenJDK 11 and complete the configuration.
- Install a Browser Driver(Chrome Driver).
- Setup a Selenium project with the name `EBankAppTest4`
- Update the Build in `pom.xml`. Refer to previous exercises for reference.


You can refer to this [Reading Material](https://learning.ccbp.in/qa-automation-testing/course?c_id=cf952b35-27ab-4b1e-a6de-44227f22806c&s_id=f5c19277-3889-4e63-b631-c06c088d612c&t_id=6a935df7-2c93-477c-b505-3ae0aabcf9a2#31-installing-ide) to complete the above prerequisites.

**Application URL**: `https://qaebank.ccbp.tech/ebank/login`

### Test Instructions

- Create a new package `pages` in the `src/test/java` directory.
- Create a `LoginPage` class in the `pages` package.
    
    
    <details>
    <summary>Define the locators for the Login page</summary>
    >  - Login image
    >  - List of Label texts
    >  - Login heading
    >  - "User ID" input field
    >  - "PIN" input field
    >  - "Login" button
    >  - Error Message (<span>)
    </details>
    <details>
    <summary>Define the methods for performing actions on the elements</summary>
    >  - Find the Login image
    >  - Get the text content of the Login heading
    >  - Get the text content of the label at a specified index
    >  - Enter a text in the "User ID" input field
    >  - Enter a text in the "PIN" input field
    >  - Click the "Login" button
    >  - Enter with the given credentials and click the "Login" button
    >  - Wait and get the text content of the error message
    </details>
- Create a `HomePage` class in the `pages` package.
    
    
    <details>
    <summary>Define the locators for the Home page</summary>
    >  - Heading text
    >  - App logo image
    >  - Digital card image
    >  - "Logout" button
    </details>
    <details>
    <summary>Define the methods for performing actions on the elements</summary>
    >  - Get the text content of the Heading
    >  - Find the App logo image
    >  - Find the Digital card image
    >  - Click the "Logout" button
    </details>
- Create a `LoginPageTest` class and write the test cases for the below test scenarios,

  _Note: The test cases should be executed in the same order as given below_

    <details>
    <summary>Test the Login Page UI</summary>
    >- Navigate to the URL `https://qaebank.ccbp.tech/ebank/login`
    >- Verify if the Login image is displayed - _use Assertions_,
    >    - If the Login image is not displayed, print "Login image is not displayed"
    >- Verify the User ID label text - _use Assertions_,
    >    - Expected text: `User ID`
    >    - If the Label text does not match the expected text, print "User id label text does not match"
    >- Verify the Pin label text - _use Assertions_,
    >    - Expected text: `PIN`
    >    - If the Label text does not match the expected text, print "Pin label text does not match"
    >- Verify the Heading text of the Login page - _use Assertions_,
    >    - Expected text: `Invalid user ID`
    >    - If the Heading text does not match the expected text, print "Heading text does not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the submission with empty input fields</summary>
    >- Navigate to the URL `https://qaebank.ccbp.tech/ebank/login`
    >- Click the "Login" button.
    >- Verify the error message - _use Assertions_,
    >    - Expected text: `Invalid user ID`
    >    - If the error message does not match the expected text, print "Error text with empty input fields does not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the submission with empty User ID field</summary>
    >- Navigate to the URL `https://qaebank.ccbp.tech/ebank/login`
    >- Login to the application, only with the PIN `231225`.
    >- Verify the error message - _use Assertions_,
    >    - Expected text: `Invalid user ID`
    >    - If the error message does not match the expected text, print "Error text with empty input field do not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the submission with empty PIN field</summary>
    >- Navigate to the URL `https://qaebank.ccbp.tech/ebank/login`
    >- Login to the application, only with the User ID `142420`.
    >- Verify the error message - _use Assertions_,
    >    - Expected text: `Invalid PIN`
    >    - If the error message does not match the expected text, print "Error text with empty input field do not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the submission with invalid PIN</summary>
    >- Navigate to the URL `https://qaebank.ccbp.tech/ebank/login`
    >- Login to the application, with the User ID `142420` and PIN `123456`.
    >- Verify the error message - _use Assertions_,
    >    - Expected text: `User ID and PIN didn't match`
    >    - If the error message does not match the expected text, print "Error text with invalid PIN do not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the successful login</summary>
    >- Navigate to the URL `https://qaebank.ccbp.tech/ebank/login`
    >- Login to the application, with the User ID `142420` and PIN `231225`.
    >- Wait and verify the navigation to the home page - _use Assertions_,
    >    - Expected URL: `https://qaebank.ccbp.tech/`
    >    - If the current URL does not match the expected URL, print "URLs do not match"
    >- Close the browser window.
    </details>
- Create a `HomePageTest` class and write the test cases for the below test scenarios,

     _Note: The test cases should be executed in the same order as given below_

    <details>
    <summary>Test the Home page UI</summary>
    >- Navigate to the URL `https://qaebank.ccbp.tech/ebank/login`
    >- Login to the application, with the User ID `142420` and PIN `231225`.
    >- Wait until the web driver navigates to the home page 
    >    - Home Page URL: `https://qaebank.ccbp.tech/`
    >- Verify if the App logo is displayed - _use Assertions_,
    >    - If the App logo is not displayed, print "App logo is not displayed"
    >- Verify the Heading text of the home page - _use Assertions_
    >    - Expected text: `Your Flexibility, Our Excellence`
    >    - If the Heading text does not match the expected text, print "Heading text does not match" 
    >- Verify if the Digital card image is displayed - _use Assertions_,
    >    - If the Digital card image is not displayed, print "Digital card image is not displayed"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the Logout functionality</summary>
    >- Navigate to the URL `https://qaebank.ccbp.tech/ebank/login`
    >- Login to the application, with the User ID `142420` and PIN `231225`.
    >- Wait until the web driver navigates to the home page 
    >    - Home Page URL: `https://qaebank.ccbp.tech/`
    >- Click the "Logout" button.
    >- Verify the navigation to the login page - _use Assertions_,
    >    - Expected URL: `https://qaebank.ccbp.tech/ebank/login/`
    >    - If the current URL does not match the expected URL, print "URLs do not match" 
    >- Close the browser window.
    </details>

### Running Tests

- In the `testng.xml` keep the `LoginPageTest` and `HomePageTest` classes in separate `<test>` XML elements.
- Use Parallel testing with _parallel_ attribute values as **tests** and _thread-count_ required for the tests to run parallel.

<br>
<br>

**Note: Set up the project and practice this exercise in your local IDE(IntelliJ).**
package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find login link and click on login link and
        clickOnElement(By.linkText("Log in"));
        verifyText("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome Text Display");

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find login link and click on login link
        clickOnElement(By.linkText("Log in"));

        sendTextToElement(By.id("Email"), "Mike@yahoo.com");

        sendTextToElement(By.id("Password"), "abcd1234");

        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        verifyText("Log out", (By.className("ico-logout")), "Log Out");
    }

    @Test
    public void verifyTheErrorMessage() {
        //find login link and click on login link

        clickOnElement(By.linkText("Log in"));

        sendTextToElement(By.id("Email"), "mike1@yahoo.com");

        sendTextToElement(By.id("Password"), "abcd12345");

        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
//        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
//                "No customer account found";
//        WebElement actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
//        String actualerrorMessage = actualErrorMessage.getText();//using .getText() method
//        System.out.println(actualerrorMessage);
//        //By using'Assert'keyword verifying the expected and actual result
//        Assert.assertEquals("Error message not Displayed:", expectedErrorMessage, actualerrorMessage);
        verifyText("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found",By.xpath("//div[@class='message-error validation-summary-errors']"),"\"Error message not Displayed:\"");
    }

    @After
    public void close() {
        closeBrowser();
    }

}


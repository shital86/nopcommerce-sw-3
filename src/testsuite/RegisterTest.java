package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // WebElement registerButton = driver.findElement(By.linkText("Register"));//register button locator
        //registerButton.click();//click register button
        clickOnElement(By.linkText("Register"));
        //WebElement registerText = driver.findElement(By.linkText("Register"));//register text locator
        //String actualMessage = registerText.getText();// get text
        //String expectedMessage = "Register";// stored expected msg
        //Assert.assertEquals("Register Text not visible", expectedMessage, actualMessage);// validation of actual and expected
        verifyText("Register", By.linkText("Register"), "Register");
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        clickOnElement(By.linkText("Register"));
        sendTextToElement(By.id("FirstName"), "Mike");
        sendTextToElement(By.id("LastName"), "Marsh");
        sendTextToElement(By.id("Email"), "Mike@yahoo.com");
        sendTextToElement(By.id("Password"), "abcd1234");
        sendTextToElement(By.id("ConfirmPassword"), "abcd1234");
        clickOnElement(By.id("register-button"));
        verifyText("Your registration completed", By.xpath("//div[@class='page-body']//div[@class='result']"), "Registration completed text not visible");
    }

    @After
    public void close() {
        closeBrowser();

    }
}

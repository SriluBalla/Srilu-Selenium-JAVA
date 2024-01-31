package steps;

import helpers.browserStep;
import helpers.constants;
import helpers.screenshotHelper;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.browserHelper.getDriver;
import static helpers.envHelper.chooseEnv;
import static helpers.envHelper.getBaseURL;

public class loginStep {

    private static final WebDriver driver = getDriver();
    private static WebElement element;

    private static WebElement fEmail() {
        element = driver.findElement(By.id("user[email]"));
        return element;
    }

    private static WebElement fPassword() {
        element = driver.findElement(By.id("user[password]"));
        return element;
    }

    private static WebElement btnSignIn(){
        element = driver.findElement(By.className("button button-primary g-recaptcha"));
        return element;
    }

// Functions
public static void loginAs(String user, String pass) throws Exception {
    fEmail().clear();
    fEmail().sendKeys(user);
    fPassword().clear();
    fPassword().sendKeys(pass);
    btnSignIn().click();
}

// Steps
    @Given("^I am on the Ultimate QA website$")
    public static void goToUltimate() throws Throwable {
        browserStep.goToURL(getBaseURL("/users/sign_up"));
        screenshotHelper.Page("Home");
    }

    @Given("^I Log a message$")
    public static void logMessage() throws Throwable {
        System.out.println("This is a successful test");
    }

    @Given("^I am logged into the Ultimate QA$")
    public static void logIntoUltimate() throws Throwable {

        browserStep.goToURL(chooseEnv());
        loginStep.loginAs(constants.email, constants.pass);
        Thread.sleep(1000);
    }


}

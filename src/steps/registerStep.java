package steps;

import helpers.browserStep;
import helpers.constants;
import helpers.screenshotHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static helpers.browserHelper.getDriver;
import static helpers.envHelper.getBaseURL;

public class registerStep {

    private static final WebDriver driver = getDriver();
    private static WebElement element;

    private static WebElement btnSignUp(){
        element = driver.findElement(By.className("button"));
        //*[@id="sign_up_58edbe948d"]/div[7]/button
        return element;
    }

    private static WebElement fEmail() {
        element = driver.findElement(By.id("user[email]"));
        return element;
    }

    private static WebElement fFirstname() {
        element = driver.findElement(By.id("user[first_name]"));
        return element;
    }

    private static WebElement fLastname() {
        element = driver.findElement(By.id("user[last_name]"));
        return element;
    }

    private static WebElement fPassword() {
        element = driver.findElement(By.id("user[password]"));
        return element;
    }

    private static WebElement cbTerms() {
        element = driver.findElement(By.id("user[terms]"));
        return element;
    }

    private static WebElement errText(int i) {
        element = driver.findElements(By.className("form-error__list-item")).get(i);
        return element;
    }

// Functions
    public static void Register(String first, String last, String user, String pass) {
        fFirstname().clear();
        fFirstname().sendKeys(first);
        fLastname().clear();
        fLastname().sendKeys(last);
        fEmail().clear();
        fEmail().sendKeys(user);
        fPassword().clear();
        fPassword().sendKeys(pass);
        btnSignUp().click();
    }

// Steps
    @Given("^I am on the Ultimate QA Registration page$")
    public static void goToUltimate() throws Throwable {
        browserStep.goToURL(getBaseURL("/users/sign_up"));
        screenshotHelper.Page("Registration");
    }
    @Given("^I see the page Registration$")
    public static void onRegPage() throws Throwable {
        browserStep.verifyTitle(constants.title_Register);
        System.out.println();
    }

    @Given ("^Click button Sign in$")
    public static void regEmpty() throws InterruptedException {
        Assert.assertTrue(btnSignUp().isDisplayed());
    btnSignUp().click();
    }

    @Then("^I see error message (.*) at (.*)$")
    public static void errMessage(int i, String red)  {
        String err = String.valueOf(errText(i));
        Assert.assertEquals(err, red);
    }

}

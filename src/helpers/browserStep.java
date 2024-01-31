package helpers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static helpers.browserHelper.getDriver;

public class browserStep {

    private static WebDriver driver = getDriver();
    static Wait<WebDriver> wait;

    //  Invoke Browser
    // // Go to URL
    @When("^Go to URL - (.*)$")
    public static void goToURL(String url){
        driver.get(url);
        System.out.println(driver.getCurrentUrl());
    }

    @Then("^Verify page title \"([^\"]*)\"$")
    public static void verifyTitle (String title) throws Exception   {
        assert(driver.getTitle().contains(title));
    }

    // //  // Close Tab
    @When("^Close Tab$")
    public static void closeTab(){
        driver.close();
    }

    // //  // Kill Browser process
    @When("^Quit browser$")
    public static void quitBrowser(){
        driver.close();
        driver.quit();
    }

    //  //  Cookies and Cache
    @When("^Delete All Cookies$")
    public static void delAllCookies(){
        driver.manage().deleteAllCookies();
        System.out.println("\n Deleted All Cookies");
    }

    @When("^Delete one Cookie - (.*)$")
    public static void delCookie(Cookie cookie){
        driver.manage().deleteCookie(cookie);
        System.out.println("\n Deleted Cookie = " + cookie);
    }

    @When("^Add one Cookie - (.*)$")
    public static void addCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
        System.out.println("\n Added one Cookie = " + cookie);
    }


    // // // Hover
    @When("^Hover over element - (.*)$")
    public static void HoverOver(WebElement element){
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
        System.out.println("\n Hovering over element = " + element);
    }

    // // Scroll To
    @When("^Scroll to element - (.*)$")
    public static void scrollTo(WebElement element) throws InterruptedException{
        Actions scroll = new Actions(driver);
        scroll.moveToElement(element);
        scroll.perform();
        System.out.println("\n Scroll to element = " + element);
    }

    public static void justScroll() throws InterruptedException {
        Actions scroll = new Actions(driver);
        scroll.keyDown(Keys.ARROW_DOWN).perform();
        scroll.keyDown(Keys.ARROW_DOWN).perform();
        scroll.keyDown(Keys.ARROW_DOWN).perform();
        scroll.keyDown(Keys.ARROW_DOWN).perform();
        scroll.keyDown(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
    }


    @When("^Scroll into View of element - (.*)$")
    public static void scrollToView(WebElement element) throws InterruptedException{
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        System.out.println("\n Scroll to element = " + element);
    }

    // //  // Select between tabs
// For the main Tab
    @When("^Focus on Main Window$")
    public static void focusMain(){
        for(String Main : driver.getWindowHandles()){
            driver.switchTo().window(Main);
        }
    }

    // For the New Tab
    @When("^Shift Focus on New Tab$")
    public static void focusNewTab(){
        for(String newTab : driver.getWindowHandles()){
            driver.switchTo().window(newTab);
        }
    }

    //  //  // Upload File
    @When("^Upload file - (.*)$")
    public static void uploadFile(WebElement element, String filePath) {
        element.sendKeys(filePath);
        System.out.println("\n Uploaded File = " + filePath);
    }

    // //  // Maximize Window
    @When("^Maximize window$")
    public static void full(){
        driver.manage().window().maximize();
        System.out.println("\n Window Maximied Fully");
    }

    // //  // Minimize / Maximize to Window
    @When("^Size browser to (\\d+) and (\\d+)$")
    public static void minim(int h, int w){
        Dimension s = new Dimension(h, w);
        driver.manage().window().setSize(s);
        System.out.println("\n Browser sized to = " + w + "x" + h);
    }

    @When("^Size Browser to half$")
    public static void half(){
        minim(1250, 1100);
        System.out.println("\n Browser sized to half");
    }

    @When("^Size Browser to Tablet$")
    public static void tablet(){
        minim(800, 1000);
        System.out.println("\n Browser sized to Tablet");
    }

    @When("^Size Browser to phone$")
    public static void phone(){
        minim(400, 700);
        System.out.println("\n Browser sized to Phone");
    }

    //  //  //Get Current URL
    @When("^Get Current URL")
    public static void getURL(){
        String currURL =  driver.getCurrentUrl();
    }

    // //  // Go back one page
    @When("^Go back one page$")
    public static void oneBack(){
        driver.navigate().back();
    }

    // //  // Go forward one page
    @When("^Go forward one page$")
    public static void oneForward(){
        driver.navigate().forward();
    }

    // //  // Refresh current page
    @When("^Refresh page$")
    public static void refresh(){
        driver.navigate().refresh();
    }

    // Emulate Chrome to immitate mobile browser
    @When("^Emulate Browser to Mobile Phone - (.*)$")
    public static void emulateChrome(String phoneType){
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", phoneType);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
    }

    public static void err404(WebDriver driver) {
        if (driver.getCurrentUrl().contains("404 Page Not Found")){
            System.err.println("Invalid URL - Page Title = " + driver.getTitle());
        }
    }

    // WAIT TIME
    @When("^Wait minutes (.*)$")
    public static void waitMin(int i)
    {
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.MINUTES);
    }

    @When("^Wait seconds (.*)$")
    public static void waitSec(int i)
    {
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }
}

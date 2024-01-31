package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class browserHelper {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            driver = chooseDriver();
        }
        return driver;
    }

    public static WebDriver chooseDriver(){

        String browser = System.getProperty("BROWSER");

        if(browser == null) {
            browser = System.getenv("BROWSER");

            if (browser == null){
                browser = "chrome";
            }
        }
        switch (browser){
            case "chrome":
                System.setProperty("web.chrome.driver", "src/main/resources/_macDrivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        System.out.println("\nInvoked browser = " +  browser);
        return driver;
    }
}

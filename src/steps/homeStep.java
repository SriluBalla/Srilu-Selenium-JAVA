package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.browser.getDriver;

public class homeStep {

    public static final WebDriver driver = getDriver();
    private static WebElement element;

    private static WebElement fSearch() {
        element = driver.findElement(By.id("APjFqb"));
        return element;
    }

// Functions


// Steps
    public static void search(String search) throws Throwable {
        fSearch().sendKeys(search);
        fSearch().sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }


}

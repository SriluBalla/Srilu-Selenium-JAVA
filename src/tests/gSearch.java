package tests;

import helpers.browserStep;
import helpers.constants;
import helpers.environment;
import helpers.screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.homeStep;
import java.util.ArrayList;
import java.util.List;

import static steps.homeStep.driver;

public class gSearch {

    public static void main(String[] args) throws Throwable {

        String search = constants.search_keyword;

        browserStep.goToURL(environment.getBaseURL(""));
        browserStep.verifyTitle(constants.title_google);

        homeStep.search(search);

        // Capture the main HREFs into an array
        List<String> h3Links = new ArrayList<String>();
        List<WebElement> gLinks = driver.findElements(By.partialLinkText("Srilu"));

        System.out.println("Total number of links for keyword " + search + " = " + gLinks.size());

        for (WebElement pageLink : gLinks ) {
            h3Links.add(pageLink.getAttribute("href"));
        }

        for ( String link : h3Links ) {
            browserStep.goToURL(link);
            System.out.println(driver.getTitle());
            browserStep.waitSec(1);
            screenshot.page(driver.getTitle());
        }
        browserStep.quitBrowser();
    }

}

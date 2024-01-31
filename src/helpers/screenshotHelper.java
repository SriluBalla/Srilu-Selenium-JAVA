package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static helpers.browserHelper.getDriver;

public class screenshotHelper {

    private static WebDriver driver = getDriver();
    private static File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    static Wait<WebDriver> wait;


    public static void Page(String fileName) throws IOException {

        Date d = new Date();
        String date = d.toString().substring(0, 10);
        String screenshots = "/Users/sriluballa/Documents/AUTOMATION/Screenshots";

        new File(screenshots + "/" + date).mkdir();

        FileHandler.copy(srcFile, new File(  screenshots + "/" + date + "/" + fileName + ".jpg"));
        System.out.println("Image Posted = " + screenshots + "/" + date +  "/" + fileName + ".jpg");
    }
}

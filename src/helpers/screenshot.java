package helpers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class screenshot {

    public static String date() {
        Date d = new Date();
        return d.toString().substring(0, 10);
    }

    public static String fileLocation = constants.screenshots + "/" + date();

    public static void page(String fileName) throws AWTException, IOException {
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image = robot.createScreenCapture(rectangle);

        new File(fileLocation).mkdir();
        File file = new File(fileLocation + "/" + fileName + ".jpg");
        ImageIO.write(image, "jpg", file);
        System.out.println("Image Posted to - " + fileLocation +  "/" + fileName + ".jpg");
    }

    public static void wholeScreen(String fileName) throws Exception {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();
        Rectangle allScreenBounds = new Rectangle();

        for (GraphicsDevice screen : screens) {
            Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();
            allScreenBounds.width += screenBounds.width;
            allScreenBounds.height = Math.max(allScreenBounds.height, screenBounds.height);
        }

        BufferedImage capture = new Robot().createScreenCapture(allScreenBounds);
        File file = new File(fileLocation + "/" + fileName + ".jpg");
        ImageIO.write(capture, "jpg", file);
    }
}

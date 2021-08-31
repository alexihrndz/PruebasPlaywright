package co.arhernandez.svp.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GetScreenshots {

  public static ScreenshotOptions options() {

    String timeStamp =
        new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
            .format(new Timestamp(System.currentTimeMillis()));
    ScreenshotOptions options =
        new Page.ScreenshotOptions()
            .setPath(
                Paths.get(
                    System.getProperty("sreenshots.path", "target/site/caps/")
                        + timeStamp
                        + "capture"
                        + ".png"));

    return options;
  }
}

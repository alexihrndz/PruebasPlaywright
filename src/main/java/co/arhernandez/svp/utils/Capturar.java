package co.arhernandez.svp.utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

public class Capturar implements Performable, IsHidden {

  private Page page;

  public static Performable pantalla() {
    return new Capturar();
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    page = BrowseTheWebWithPlaywright.as(actor).getCurrentPage();
    page.waitForLoadState();
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
    page.screenshot(options);
  }

  public static Performable cap(String nombre) {
    String timeStamp =
        new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
            .format(new Timestamp(System.currentTimeMillis()));
    ScreenshotOptions options =
        new Page.ScreenshotOptions()
            .setPath(
                Paths.get(
                    System.getProperty("sreenshots.path", "target/site/caps/")
                        + timeStamp
                        + nombre
                        + ".png"));

    return Task.where(
        "{0} Captura " + options.path,
        actor -> BrowseTheWebWithPlaywright.as(actor).getCurrentPage().screenshot(options));
  }
}

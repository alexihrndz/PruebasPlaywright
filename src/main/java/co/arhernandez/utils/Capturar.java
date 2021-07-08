package co.arhernandez.utils;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

public class Capturar extends ClassLoader implements Performable, IsHidden {

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
            .setPath(Paths.get("target/Evidencias/capture" + timeStamp + ".png"));
    page.screenshot(options);
  }
}

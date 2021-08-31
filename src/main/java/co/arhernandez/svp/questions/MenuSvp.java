package co.arhernandez.svp.questions;

import com.microsoft.playwright.Page;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

public class MenuSvp implements Question<Boolean> {

  public static MenuSvp esVisible() {
    return new MenuSvp();
  }

  public static Question<Boolean> esVisibleConPW() {
    return new MenuSvpPW();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    Page page = BrowseTheWebWithPlaywright.as(actor).getCurrentPage();
    page.waitForLoadState();
    Page.WaitForSelectorOptions options = new Page.WaitForSelectorOptions().setTimeout(30000);
    page.waitForSelector("//div[@class='main-content']", options);
    return page.isVisible("//div[@class='main-content']");
  }
}

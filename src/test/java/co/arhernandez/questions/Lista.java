package co.arhernandez.questions;

import co.arhernandez.userinterfaces.YouTubeHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import net.serenitybdd.screenplay.playwright.assertions.Ensure;
import net.serenitybdd.screenplay.playwright.interactions.WaitFor;

public class Lista implements Question<String> {

  public static Lista deCanciones() {
    return new Lista();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitFor.selector(YouTubeHomePage.LBL_TITULOS),
        Ensure.that(YouTubeHomePage.LBL_TITULOS).isVisible()
    );
    String titulo = BrowseTheWebWithPlaywright.as(actor).getCurrentPage()
        .textContent("[class='title-and-badge style-scope ytd-video-renderer']");

    return titulo;
  }
}

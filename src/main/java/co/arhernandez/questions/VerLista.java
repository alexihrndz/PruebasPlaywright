package co.arhernandez.questions;

import static co.arhernandez.userinterfaces.YouTubeHomePage.LBL_TITULOS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import net.serenitybdd.screenplay.playwright.assertions.Ensure;
import net.serenitybdd.screenplay.playwright.interactions.WaitFor;

public class VerLista implements Question<String> {

  public static VerLista deCanciones() {
    return new VerLista();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitFor.selector(LBL_TITULOS),
        Ensure.that(LBL_TITULOS).isVisible());

    return BrowseTheWebWithPlaywright.as(actor)
        .getCurrentPage()
        .textContent(LBL_TITULOS);
  }
}

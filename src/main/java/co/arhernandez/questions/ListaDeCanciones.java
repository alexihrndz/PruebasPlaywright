package co.arhernandez.questions;

import static co.arhernandez.userinterfaces.YouTubeHomePage.LBL_TITULOS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.assertions.Ensure;
import net.serenitybdd.screenplay.playwright.interactions.WaitFor;
import net.serenitybdd.screenplay.playwright.questions.PlaywrightQuestions;


public class ListaDeCanciones implements Question<String> {

  public static ListaDeCanciones ver() {
    return new ListaDeCanciones();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitFor.selector(LBL_TITULOS),
        Ensure.that(LBL_TITULOS).isVisible());

    return PlaywrightQuestions.textOf(LBL_TITULOS).answeredBy(actor);
  }
}

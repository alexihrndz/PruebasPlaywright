package co.arhernandez.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.arhernandez.userinterfaces.YouTubeHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class Buscar implements Task {

  private String nombreVideo;

  public Buscar(String nombreVideo) {
    this.nombreVideo = nombreVideo;
  }

  public static Buscar video(String nombreVideo) {
    return instrumented(Buscar.class, nombreVideo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(nombreVideo).into(YouTubeHomePage.TXT_BUSCAR),
        Click.on(YouTubeHomePage.BTN_BUSCAR));
  }
}

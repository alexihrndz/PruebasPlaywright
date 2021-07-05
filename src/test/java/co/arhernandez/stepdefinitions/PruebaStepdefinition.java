package co.arhernandez.stepdefinitions;

import static co.arhernandez.userinterfaces.YouTubeHomePage.LBL_ICONO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import co.arhernandez.questions.Lista;
import co.arhernandez.tasks.Buscar;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

import net.serenitybdd.screenplay.playwright.assertions.Ensure;
import net.serenitybdd.screenplay.playwright.interactions.Open;

public class PruebaStepdefinition {

  LaunchOptions launchOptions = new LaunchOptions();

  @Before
  public void setContext() {
    OnStage.setTheStage(new OnlineCast());
    launchOptions.headless = true;
  }

  @Entonces("el puede ver el inicio de sesion")
  public void verficaInicioDeSesion() {}

  @Dado("^que (.*) ingresa a youtube$")
  public void ingresaAYoutube(String nombreActor) {
    theActorCalled(nombreActor)
        .whoCan(BrowseTheWebWithPlaywright.withOptions(launchOptions));
    theActorInTheSpotlight().attemptsTo(
        Open.url("https://www.youtube.com/"),
        Ensure.that(LBL_ICONO)
            .isVisible());

  }

  @Cuando("^el busca el video (.*)$")
  public void buscarVideo(String nombreVideo) {
    theActorInTheSpotlight().attemptsTo(Buscar.video(nombreVideo));
  }

  @Entonces("^el puede ver en la lista de videos disponibles: (.*)$")
  public void verificarListaDeVideos(String resultado) {
    theActorInTheSpotlight().should(seeThat(Lista.deCanciones(), containsString(resultado)));
  }
}

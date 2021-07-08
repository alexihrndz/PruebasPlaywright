package co.arhernandez.stepdefinitions;

import static co.arhernandez.userinterfaces.YouTubeHomePage.LBL_ICONO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import co.arhernandez.questions.ListaDeCanciones;
import co.arhernandez.tasks.Buscar;
import co.arhernandez.utils.Capturar;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.BrowserChannel;
import com.microsoft.playwright.options.ColorScheme;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import java.util.ArrayList;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import net.serenitybdd.screenplay.playwright.assertions.Ensure;
import net.serenitybdd.screenplay.playwright.interactions.Open;

public class BuscarYoutubeStepdefinitions {

  LaunchOptions launchOptions = new LaunchOptions();

  @Before
  public void setContext() {
    OnStage.setTheStage(new OnlineCast());
    launchOptions.headless = true;
  }

  @Dado("^que (.*) ingresa a YouTube")
  public void ingresaAYoutube(String nombreActor) {
    theActorCalled(nombreActor).whoCan(BrowseTheWebWithPlaywright.withOptions(launchOptions));
    theActorInTheSpotlight()
        .attemptsTo(Open.url("https://www.youtube.com/"), Ensure.that(LBL_ICONO).isVisible(),
            Capturar.pantalla());
  }

  @Cuando("^el busca el video (.*)$")
  public void buscarVideo(String nombreVideo) {
    theActorInTheSpotlight().attemptsTo(Buscar.video(nombreVideo));
  }

  @Entonces("^puede ver primero en la lista de videos disponibles: (.*)$")
  public void verificarListaDeVideos(String resultado) {
    theActorInTheSpotlight().should(seeThat(ListaDeCanciones.ver(), containsString(resultado)));
  }
}

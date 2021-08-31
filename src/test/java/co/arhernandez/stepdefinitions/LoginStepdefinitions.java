package co.arhernandez.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.arhernandez.svp.questions.MenuSvp;
import co.arhernandez.svp.tasks.autenticacion.IniciarSesion;
import co.arhernandez.svp.tasks.autenticacion.IniciarSesionConPlaywright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

public class LoginStepdefinitions {

  LaunchOptions launchOptions = new LaunchOptions();

  @Before
  public void setContext() {
    OnStage.setTheStage(new OnlineCast());
    launchOptions.headless = false;
  }

  @Cuando("^(.*) ingresa con el usuario: (.*) y la clave: (.*)$")
  public void inicioSesion(String nombreActor, String usuario, String clave) {
    theActorCalled(nombreActor)
        .whoCan(BrowseTheWebWithPlaywright.withOptions(launchOptions))
        .attemptsTo(IniciarSesion.enSvp(usuario, clave));
  }

  @Cuando("^(.*) ingreso con el usuario: (.*) y la clave: (.*)$")
  public void inicioSesionPlaywright(String actor, String usuario, String clave) {
    theActorCalled(actor).wasAbleTo(IniciarSesionConPlaywright.enSvp(usuario, clave));
  }

  @Entonces("el puede observar sus productos")
  public void elPuedeObservarSusProductos() {
    theActorInTheSpotlight().should(seeThat(MenuSvp.esVisible()));
  }

  @Entonces("el puede observar sus productos con playwright")
  public void elPuedeObservarSusProductosConPlaywright() {
    theActorInTheSpotlight().should(seeThat(MenuSvp.esVisibleConPW()));
  }
}

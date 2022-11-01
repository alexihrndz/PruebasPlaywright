package co.arhernandez.svp.tasks.autenticacion;

import static co.arhernandez.svp.ui.LoginPage.TXT_CLAVE;
import static co.arhernandez.svp.ui.LoginPage.TXT_USUARIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.arhernandez.svp.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;
import net.serenitybdd.screenplay.playwright.interactions.Open;

public class IniciarSesion implements Task {

  private final String usuario;
  private final String clave;

  public IniciarSesion(String usuario, String clave) {
    this.usuario = usuario;
    this.clave = clave;
  }

  public static IniciarSesion enSvp(String usuario, String clave) {
    return instrumented(IniciarSesion.class, usuario, clave);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Open.url("https://personas.banistmolabs.com"),
        Enter.theValue(usuario).into(TXT_USUARIO),
        Click.on(TXT_USUARIO),
        Click.on(LoginPage.BTN_CONTINUAR),
        Enter.theValue(clave).into(TXT_CLAVE),
        Click.on(TXT_CLAVE),
        Click.on(LoginPage.BTN_INICIAR_SESION));
  }
}

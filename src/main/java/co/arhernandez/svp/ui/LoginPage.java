package co.arhernandez.svp.ui;

import net.serenitybdd.screenplay.playwright.Target;

public class LoginPage {

  public static final Target TXT_USUARIO = Target.the("Input usuario").locatedBy("input#inp_user");
  public static final Target BTN_CONTINUAR =
      Target.the("Boton continuar").locatedBy("button#btn_continue");
  public static final Target TXT_CLAVE = Target.the("Input clave").locatedBy("input#inp_password");
  public static final Target BTN_INICIAR_SESION =
      Target.the("Boton iniciar sesion").locatedBy("button#btn_login");

  private LoginPage() {}
}

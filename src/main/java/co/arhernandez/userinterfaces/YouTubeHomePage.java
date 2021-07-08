package co.arhernandez.userinterfaces;

import net.serenitybdd.screenplay.playwright.Target;

public class YouTubeHomePage {

  public static final Target LBL_ICONO =
      Target.the("Icono YouTube").locatedBy("(//*[@id='logo-icon'])[1]");
  public static final Target TXT_BUSCAR =
      Target.the("Input buscar video").locatedBy("input#search");
  public static final Target BTN_BUSCAR =
      Target.the("Boton buscar").locatedBy("button#search-icon-legacy");
  public static final Target LBL_TITULOS =
      Target.the("Lista de Canciones")
          .locatedBy("(//*[@id='video-title']/yt-formatted-string)[1]");

  private YouTubeHomePage() {}
}

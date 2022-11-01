package co.arhernandez.svp.tasks.autenticacion;

import static co.arhernandez.svp.utils.GetScreenshots.options;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class IniciarSesionConPlaywright implements Task {

  private String usuario;
  private String clave;

  public IniciarSesionConPlaywright(String usuario, String clave) {
    this.usuario = usuario;
    this.clave = clave;
  }

  public static IniciarSesionConPlaywright enSvp(String usuario, String clave) {
    return instrumented(IniciarSesionConPlaywright.class, usuario, clave);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
      BrowserContext browserContext =
          browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
      // BrowserContext browserContext = browser.newContext();
      Page page = browserContext.newPage();

      page.navigate("https://personas.banistmolabs.com");
      page.fill("input#inp_user", usuario);
      page.click("input#inp_user");
      page.click("button#btn_continue");
      page.fill("input#inp_password", clave);
      page.click("input#inp_password");
      page.click("button#btn_login");
      page.screenshot(options());

      Page.WaitForSelectorOptions waitForSelectorOptions =
          new Page.WaitForSelectorOptions().setTimeout(30000);
      page.waitForSelector("//div[@class='main-content']", waitForSelectorOptions);
      page.screenshot(options());
      page.isVisible("//div[@class='main-content']");
    }
  }
}

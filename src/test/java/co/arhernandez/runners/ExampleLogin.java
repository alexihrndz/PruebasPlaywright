package co.arhernandez.runners;

import static co.arhernandez.svp.utils.GetScreenshots.options;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleLogin {

  static Playwright playwright;
  static Browser browser;

  // New instance for each test method.
  BrowserContext context;
  Page page;

  @BeforeAll
  static void launchBrowser() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
  }

  @AfterAll
  static void closeBrowser() {
    playwright.close();
  }

  @BeforeEach
  void createContextAndPage() {
    context = browser.newContext();
    page = context.newPage();
  }

  @AfterEach
  void closeContext() {
    context.close();
  }

  @Test
  void loginBanistmo() {
    page.navigate("https://personas.banistmolabs.com");
    page.fill("input#inp_user", "antonio123_");
    page.click("input#inp_user");
    page.click("button#btn_continue");
    page.fill("input#inp_password", "Prueba123##");
    page.click("input#inp_password");
    page.click("button#btn_login");
    page.screenshot(options());

    Page.WaitForSelectorOptions waitForSelectorOptions =
        new Page.WaitForSelectorOptions().setTimeout(30000);
    page.waitForSelector("//div[@class='main-content']", waitForSelectorOptions);
    page.isVisible("//div[@class='main-content']");
    page.screenshot(options());
  }
}

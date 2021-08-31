package co.arhernandez.svp.utils.examples;

import static co.arhernandez.svp.utils.GetScreenshots.options;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
      // BrowserContext browserContext = browser.newContext(new
      // NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
      BrowserContext browserContext = browser.newContext();
      Page page = browserContext.newPage();

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
    }
  }
}

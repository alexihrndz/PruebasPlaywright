package co.arhernandez.examples;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      BrowserType webkit = playwright.firefox();
      Browser browser = webkit.launch();
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://www.gmail.com/");
      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshot.png")));
      browser.close();
    }
  }
}

package org.przemyslawKl;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import java.util.List;

class BrowserTest {

    @Test()
    void user_should_open_all_supported_browsers() {

        Playwright playwright = Playwright.create();
        List<BrowserType> browsers = List.of(playwright.chromium(), playwright.firefox(), playwright.webkit());

        for (BrowserType browserType : browsers) {
            Browser browser = browserType.launch();

            Page page = browser.newPage();
            page.navigate("www.onet.pl");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/" + browserType.name()+ ".png")));
        }
    }
}

      /*
        Playwright playwright = Playwright.create();   utworzenie obiektu Playwirght
        Browser browser = playwright.chromium().launch()  przypisanie browsertype do zmiennej browser i odpalenie przeglądarki
        Page page = browser.newPage(); przeglądarka newPage przypisania do zmiennej page
        */
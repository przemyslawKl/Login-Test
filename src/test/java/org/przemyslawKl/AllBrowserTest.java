package org.przemyslawKl;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;

class AllBrowserTest extends BaseTest {
    @Test
    void user_should_get_screen_shot_from_chrome(){
        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/chromium.png")));
    }
    @Test
    void user_should_get_screen_shot_from_firefox(){
        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/firefox.png")));
    }
    @Test
    void user_should_get_screen_shot_from_safari(){
        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/safari.png")));
    }
}

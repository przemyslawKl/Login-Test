package org.przemyslawKl;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

class LoginTest extends BaseTest{


    @Test
    void verify_if_user_can_login_with_valid_username_and_password() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("username").fill("tomsmith");
        page.getByLabel("password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("login", Pattern.CASE_INSENSITIVE))).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).not().isVisible();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).isVisible();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
        PlaywrightAssertions.assertThat(page.getByText("You logged out of the secure area!")).isVisible();
    }
    @Test
    void verify_if_user_can_login_with_invalid_username_and_password() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("username").fill("tomsmith123");
        page.getByLabel("password").fill("PasswordVerySecret12!@");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("login", Pattern.CASE_INSENSITIVE))).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).not().isVisible();
    }
    @Test
    void verify_if_user_can_login_with_invalid_username_and_valid_password() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("username").fill("tomsmith123");
        page.getByLabel("password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("login", Pattern.CASE_INSENSITIVE))).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).not().isVisible();
    }
    @Test
    void verify_if_user_can_login_with_valid_username_and_invalid_password() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("username").fill("tomsmith");
        page.getByLabel("password").fill("PasswordVerySecret12!@");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("login", Pattern.CASE_INSENSITIVE))).click();
        PlaywrightAssertions.assertThat(page.getByText("Your password is invalid!")).isVisible();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).not().isVisible();
    }
    @Test
    void verify_if_user_can_login_with_no_username_and_password() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("username").fill(" ");
        page.getByLabel("password").fill(" ");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("login", Pattern.CASE_INSENSITIVE))).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).not().isVisible();
    }
    @Test
    void verify_if_user_can_login_with_valid_username_and_empty_password() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("username").fill("tomsmith");
        page.getByLabel("password").fill(" ");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("login", Pattern.CASE_INSENSITIVE))).click();
        PlaywrightAssertions.assertThat(page.getByText("Your password is invalid!")).isVisible();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).not().isVisible();
    }
    @Test
    void verify_if_user_can_login_with_empty_username_and_valid_password() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("username").fill(" ");
        page.getByLabel("password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("login", Pattern.CASE_INSENSITIVE))).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
        PlaywrightAssertions.assertThat(page.getByText("You logged into a secure area!")).not().isVisible();
    }
}
package org.przemyslawKl;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class InputValidationTest extends BaseTest{
    /*
    In this input, form can throw several errors connected to length of inputs or values in it

    First name can call error when input will be shorter or equal than 2 chars
    Also first name will call error when input will be longer or equal to 90 chars
    If no value will be added into input, app will throw error that input cannot be empty

    Last name can call error when input will be shorter or equal than 10 chars
    Also last name will call error when input will be longer or equal to 80 chars

    */
    @Test
    void verify_if_user_can_submit_form_with_valid_data(){
        page.navigate("https://testpages.eviltester.com/styled/validation/input-validation.html");
        PlaywrightAssertions.assertThat(page.getByText("Input Validation Examples")).isVisible();
        page.pause();
        page.getByLabel("First name:").fill("First Name Test");
        page.getByLabel("Last name:").fill("Last Name Test");
        page.getByLabel("Age:").type("25");
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Country:")).selectOption("San Marino");
        page.getByLabel("Notes:").fill("Testing filling data");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).click();

    }
    @Test
    void verify_if_user_can_submit_form_with_invalid_age_too_small(){
        page.navigate("https://testpages.eviltester.com/styled/validation/input-validation.html");
        PlaywrightAssertions.assertThat(page.getByText("Input Validation Examples")).isVisible();
        page.pause();
        page.getByLabel("First name:").fill("First Name Test");
        page.getByLabel("Last name:").fill("Last Name Test");
        page.getByLabel("Age:").type("11");
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Country:")).selectOption("San Marino");
        page.getByLabel("Notes:").fill("Testing filling data");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).click();
    }
    @Test
    void verify_if_user_can_submit_form_with_invalid_age_too_high(){
        page.navigate("https://testpages.eviltester.com/styled/validation/input-validation.html");
        PlaywrightAssertions.assertThat(page.getByText("Input Validation Examples")).isVisible();
        page.pause();
        page.getByLabel("First name:").fill("First Name Test");
        page.getByLabel("Last name:").fill("Last Name Test");
        page.getByLabel("Age:").type("125");
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Country:")).selectOption("San Marino");
        page.getByLabel("Notes:").fill("Testing filling data");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).click();
    }
}

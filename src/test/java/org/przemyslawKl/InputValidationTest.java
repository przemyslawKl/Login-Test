package org.przemyslawKl;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class InputValidationTest extends BaseTest{
    String firstNameInput = "Kassandra";
    String lastNameInput = "Norris";
    String rightAge = "25";
    String tooYoungAge = "9";
    String tooOldAge = "152";
    String rightNotes = "Testing filling data";
    @Test
    void verify_if_user_can_submit_form_with_valid_data(){
        page.navigate("https://testpages.eviltester.com/styled/validation/input-validation.html");
        PlaywrightAssertions.assertThat(page.getByText("Input Validation Examples")).isVisible();
        page.pause();
        page.getByLabel("First name:").fill(firstNameInput);
        page.getByLabel("Last name:").fill(lastNameInput);
        page.getByLabel("Age:").type(rightAge);
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Country:")).selectOption("San Marino");
        page.getByLabel("Notes:").fill(rightNotes);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).click();

    }
    @Test
    void verify_if_user_can_submit_form_with_invalid_age_too_small(){
        page.navigate("https://testpages.eviltester.com/styled/validation/input-validation.html");
        PlaywrightAssertions.assertThat(page.getByText("Input Validation Examples")).isVisible();
        page.pause();
        page.getByLabel("First name:").fill(firstNameInput);
        page.getByLabel("Last name:").fill(lastNameInput);
        page.getByLabel("Age:").type(tooYoungAge);
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Country:")).selectOption("San Marino");
        page.getByLabel("Notes:").fill(rightNotes);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).click();
    }
    @Test
    void verify_if_user_can_submit_form_with_invalid_age_too_high(){
        page.navigate("https://testpages.eviltester.com/styled/validation/input-validation.html");
        PlaywrightAssertions.assertThat(page.getByText("Input Validation Examples")).isVisible();
        page.pause();
        page.getByLabel("First name:").fill(firstNameInput);
        page.getByLabel("Last name:").fill(lastNameInput);
        page.getByLabel("Age:").type(tooOldAge);
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Country:")).selectOption("San Marino");
        page.getByLabel("Notes:").fill(rightNotes);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).click();
    }
}

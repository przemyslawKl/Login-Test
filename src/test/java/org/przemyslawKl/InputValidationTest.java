package org.przemyslawKl;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class InputValidationTest extends BaseTest{
    
    @Test
    void check_if_form_accept_valid_informations(){
        page.navigate("https://testpages.eviltester.com/styled/validation/input-validation.html");
        PlaywrightAssertions.assertThat(page.getByText("Input Validation Examples")).isVisible();
        page.pause();
        page.getByLabel("First name:").fill("First Name Test");
        page.getByLabel("Last name:").fill("Last Name Test");
        page.getByLabel("Age:").type("25");
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Country:")).selectOption("San Marino");
        page.getByLabel("Notes:").fill("Testing filling data");

    }
}

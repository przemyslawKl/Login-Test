package org.przemyslawKl;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class InputValidationTest extends BaseTest{
    String firstNameInput = "Kassandra";
    String lastNameInput = "Norris";
    String rightAge = "25";
    String tooYoungAge = "9";
    String tooOldAge = "152";
    String rightNotes = "Testing filling data";

    private void test_add_valid_name_lastname_age(String firstname, String lastname, String age, String notes){
        page.getByLabel("First name:").fill(firstname);
        page.getByLabel("Last name:").fill(lastname);
        page.getByLabel("Age:").fill(age);
        page.getByLabel("Notes:").fill(notes);
    }

    private void add_country_to_form_and_click_submit(String countryName){
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Country:")).selectOption(countryName);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("submit")).click();
    }

    private void enter_website_and_validate_if_user_is_on_right_one(){
        page.navigate("https://testpages.eviltester.com/styled/validation/input-validation.html");
        PlaywrightAssertions.assertThat(page.getByText("Input Validation Examples")).isVisible();
    }

    @Test
    void verify_if_user_can_submit_form_with_valid_data(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(firstNameInput, lastNameInput, rightAge, rightNotes);
        add_country_to_form_and_click_submit("Poland");
    }

    @Test
    void verify_if_user_can_submit_form_with_invalid_age_too_small(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(firstNameInput, lastNameInput,tooYoungAge, rightNotes);
        add_country_to_form_and_click_submit("France");
    }
    @Test
    void verify_if_user_can_submit_form_with_invalid_age_too_high(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(firstNameInput, lastNameInput, tooOldAge, rightNotes);
        add_country_to_form_and_click_submit("Brazil");
    }
}
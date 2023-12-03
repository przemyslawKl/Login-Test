package org.przemyslawKl;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;



 class InputValidationTest extends BaseTest{
    String firstNameInput = "Kassandra";
    String shortFirstNameInput = String.valueOf(firstNameInput.charAt(0));
    String veryLongFirstNameInputCorrect = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit aenean commodo ligula eget dolor";
    String veryLongFirstNameInputNotCorrect = veryLongFirstNameInputCorrect + "a";
    String lastNameInput = "Wojciechowska";
    String shortLastNameInput = String.valueOf(lastNameInput.charAt(0));
    String veryLongLastNameInputCorrect = "Pneumonoultramicroscotamicroscopicsilicovolcanoconiosispicsilicovolcanoconiosis";
    String veryLongLastNameInputNotCorrect = veryLongLastNameInputCorrect + "a";
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

     private void enter_one_website_and_validate_if_user_is_on_right_one(){
         page.navigate("https://testpages.eviltester.com/styled/validation/input-validation.html");
         PlaywrightAssertions.assertThat(page.getByText("Input Validation Examples")).isVisible();
     }

    private void form_validation_passed(){
        PlaywrightAssertions.assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Input Validation Response"))).isVisible();
        PlaywrightAssertions.assertThat(page.getByText("Your Input passed validation")).isVisible();
    }

    private void form_validation_not_passed(){
        PlaywrightAssertions.assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Input Validation Response"))).not().isVisible();
        PlaywrightAssertions.assertThat(page.getByText("Your Input passed validation")).not().isVisible();
    }

    @Test
    void verify_if_user_can_submit_form_with_valid_data(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(firstNameInput, lastNameInput, rightAge, rightNotes);
        add_country_to_form_and_click_submit("Poland");
        form_validation_passed();
    }

    @Test
    void verify_if_user_can_submit_form_with_invalid_age_too_small(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(firstNameInput, lastNameInput,tooYoungAge, rightNotes);
        add_country_to_form_and_click_submit("France");
        form_validation_not_passed();
    }
    @Test
    void verify_if_user_can_submit_form_with_invalid_age_too_high(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(firstNameInput, lastNameInput, tooOldAge, rightNotes);
        add_country_to_form_and_click_submit("Brazil");
        form_validation_not_passed();
    }

    @Test
    void verify_if_user_can_submit_form_with_invalid_first_name_too_long(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(veryLongFirstNameInputNotCorrect, lastNameInput, rightAge, rightNotes);
        add_country_to_form_and_click_submit("Poland");
        form_validation_not_passed();
    }

    @Test
    void verify_if_user_can_submit_form_with_invalid_last_name_too_long(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(firstNameInput, veryLongLastNameInputNotCorrect, rightAge, rightNotes);
        add_country_to_form_and_click_submit("Brazil");
        form_validation_not_passed();
    }

    @Test
    void verify_if_user_can_submit_form_with_invalid_last_name_and_first_name_too_long(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(veryLongFirstNameInputNotCorrect, veryLongLastNameInputNotCorrect, rightAge, rightNotes);
        add_country_to_form_and_click_submit("Qatar");
        form_validation_not_passed();
    }

    @Test
    void verify_if_user_can_submit_form_with_valid_data_long_firstname_and_lastname(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(veryLongFirstNameInputCorrect, veryLongLastNameInputCorrect, rightAge, rightNotes);
        add_country_to_form_and_click_submit("Poland");
        form_validation_passed();
    }
    @Test
    void verify_if_user_can_submit_form_with_invalid_firstname_too_short(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(shortFirstNameInput, lastNameInput,rightAge, rightNotes);
        add_country_to_form_and_click_submit("France");
        form_validation_not_passed();
    }
    @Test
    void verify_if_user_can_submit_form_with_invalid_lastname_too_short(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(firstNameInput, shortLastNameInput,rightAge, rightNotes);
        add_country_to_form_and_click_submit("France");
        form_validation_not_passed();
    }
    @Test
    void verify_if_user_can_submit_form_with_invalid_firstname_and_lastname_too_short(){
        enter_website_and_validate_if_user_is_on_right_one();
        test_add_valid_name_lastname_age(shortFirstNameInput, shortLastNameInput,rightAge, rightNotes);
        add_country_to_form_and_click_submit("France");
        form_validation_not_passed();
    }
}
package org.przemyslawKl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

 class FirstTest extends BaseTest {

    @Test
    void user_should_return_proper_page_title() {

        page.navigate("http://www.google.com");
        Assertions.assertThat(page.title()).isEqualTo("Google");
        Assertions.assertThat(page.title()).isNotBlank();
        Assertions.assertThat(page.title()).isNotEmpty();
    }
}

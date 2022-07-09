package serenityswag.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLoggingOn extends UIInteractionSteps {

    @Managed
    WebDriver driver;

    @Test
    public void usersCanLogOnViaTheHomePage(){

        openUrl("https://www.saucedemo.com/");

        //Login as a standard user
        $("[data-test='username']").sendKeys("standard_user");
        $("[data-test='password']").sendKeys("secret_sauce");
        $("[data-test='login-button']").click();

        //Should see product catalog
        assertThat($("[class='title']").getText()).isEqualToIgnoringCase("Products");

    }
}

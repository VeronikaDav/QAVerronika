import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith({SoftAssertsExtension.class})

public class PaymentTests {
    @Test
    void positive_rub() {
        Configuration.assertionMode = SOFT;

        SelenideLogger.addListener("allure", new AllureSelenide());
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        sleep(2000);
        $(byXpath("//span[contains(text(),'рублей')]/parent::*/input")).should(exist);
        $(byXpath("//span[contains(text(),'рублей')]/parent::*/input")).setValue("100");
        sleep(2000);
        $("[type=submit]").should(exist);
        $("[type=submit]").click();
        sleep(2000);

        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("рублей"));
    }

    @Test
    void positive_usd() {
        Configuration.assertionMode = SOFT;

        SelenideLogger.addListener("allure", new AllureSelenide());
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        sleep(2000);
        $(byXpath("//span[contains(text(),'долларов')]/parent::*/input")).should(exist);
        $(byXpath("//span[contains(text(),'долларов')]/parent::*/input")).setValue("100");
        sleep(2000);
        $("[type=submit]").should(exist);
        $("[type=submit]").click();
        sleep(2000);

        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("долларов"));
    }

    @Test
    void positive_eur() {
        Configuration.assertionMode = SOFT;

        SelenideLogger.addListener("allure", new AllureSelenide());
        open("http://92.51.36.108:7777/top.academy/xpath/v01/");
        sleep(2000);
        $(byXpath("//span[contains(text(),'евро')]/parent::*/input")).should(exist);
        $(byXpath("//span[contains(text(),'евро')]/parent::*/input")).setValue("100");
        sleep(2000);
        $("[type=submit]").should(exist);
        $("[type=submit]").click();
        sleep(2000);

        $("#sum").should(exist);
        $("#sum").should(text("100"));

        $("#currency").should(exist);
        $("#currency").should(text("евро"));
    }
}

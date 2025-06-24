import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSolutionsTests {

    @BeforeAll
    static void onSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void solutionsHoverEnterprizeTest(){
        open("/");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $("ul.list-style-none").shouldBe(visible).$(byText("Enterprises")).hover().click();
        $("h1").$(byText("The AI-powered" + "developer platform"));

    }
}

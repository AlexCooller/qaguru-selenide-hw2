import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class SelenideActions {

    @BeforeAll
    static void onSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void actionsElement(){
        open("/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200, 0).release().perform();
        $("#column-a").shouldHave(attribute("draggable", "true"));
        $("#column-b").shouldHave(attribute("draggable", "true"));

    }



    @Test
    void dragAndDrop(){
        open("/drag_and_drop");
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(attribute("draggable", "true"));
        $("#column-b").shouldHave(attribute("draggable", "true"));
    }
}

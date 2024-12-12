
import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDroptest {
  SelenideElement columnA = $("#column-a");
  SelenideElement columnB = $("#column-b");
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://the-internet.herokuapp.com";
  }
  @Test
  void dragAndDropColumntest(){
    open("/drag_and_drop");
    $("#column-a").shouldHave(exactText("A"));
    $("#column-a").hover();
    actions().clickAndHold(columnA).moveToElement(columnB).release().perform();
    $("#column-a").shouldHave(exactText("B"));
    $("#column-b").shouldHave(exactText("A"));
  }

  @Test
  void ElementDragAngDropTest() {
    open("/drag_and_drop");
    $("#column-a").shouldHave(exactText("A"));
    $("#column-a").hover();
    $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
    $("#column-a").shouldHave(text("B"));
    $("#column-b").shouldHave(text("A"));
  }

  @AfterEach
  void afterEachteardown() {
    Selenide.closeWebDriver();
  }
}
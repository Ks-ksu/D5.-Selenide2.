
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSolutionstest {
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://github.com";
    Configuration.pageLoadStrategy = "eager";
  }
  @Test
  void SolutionsEnterprisetest() {
    open("/home");
    $(".HeaderMenu-wrapper").$(byText("Solutions")).hover();
    $(byTagAndText("a", "Enterprises")).click();
    $(".enterprise-hero").shouldHave(text("The AI-powered developer platform"));
  }
  @AfterEach
  void afterEachteardown() {
    Selenide.closeWebDriver();
  }
}
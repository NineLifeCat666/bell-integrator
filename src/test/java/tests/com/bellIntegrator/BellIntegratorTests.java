package tests.com.bellIntegrator;

import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Feature("UI search tests")
@Story("ui for bellintegrator.com")
@Tag("ui")
public class BellIntegratorTests extends TestBaseUI {
    @Test
    @DisplayName("Successful open OSS/BSS page")
    @AllureId("1816")
    void  successfulOpenOssBssTest() {
        step("Проверяем наличие текста Bell Integrator в футере сайта", () -> {
            $(".footer__bottom").shouldHave(Condition.text("Bell Integrator"));
        });
        step("Переходим на страницу OSS/BSS", () -> {
            $("#core-services [data-num='11']").click();
        });
        step("Проверяем что мы на странице OSS/BSS", () -> {
            $("[class=head-title]").shouldHave(Condition.text("OSS/BSS"));
        });
    }

    @Test
    @DisplayName("Successful open AutomatedLab page")
    @AllureId("1815")
    void successfulOpenAutomatedLabTest() {
        step("Нажимаем на кнопку меню на главной странице сайта", () -> {
            $("#top-menu").click();
        });
        step("В открывшемся списке переходим в пункт Automated", () -> {
            $(by("href", "http://bellintegrator.com/Automation/Automated")).click();
        });
        step("Проверяем что мы на странице Automation", () -> {
            $("[class=head-title]").shouldHave(Condition.text("Automation"));
        });
    }

    @Test
    @DisplayName("Successful Search")
    @AllureId("1814")
    void successfulSearchTest() {
        step("Открываем контекстное меню поиска", () -> {
            $("#search-open").click();
        });
        step("Вводим в поиск значение Performance Testing и нажимаем Enter", () -> {
            $(".form-control").setValue("Performance Testing").pressEnter();
        });
        step("На странице поиска переходим в Performance-Testing", () -> {
            $(by("href", "http://bellintegrator.com/Performance-Testing")).click();
        });
        step("Проверяем что страница на которую мы перешли содержит Performance Testing Services", () -> {
            $("[class=head-title]").shouldHave(Condition.text("Performance Testing Services"));
        });
    }
}

package tests.in.reqres;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("api tests")
@Story("api for reqres.in")
@Tag("api")
public class ReqResInTests extends TestBaseApi {

    @Test
    @DisplayName("Проверка на наличие элемента в ответе List Users")
    @AllureId("1808")
    void assertResponseElementInListUsersTest() {
        step("Поиск элемента в листе List User", () -> {
            steps.assertResponseElementInListUsersTest();
        });
    }

    @Test
    @DisplayName("Проверка наличия элемента в List<Resource>")
    @AllureId("1812")
    void assertResponseContainedInListResource() {
        step("Проверка наличия элемента в  List<Resource>", () -> {
            steps.assertResponseContainedInListResource();
        });
    }

    @Test
    @DisplayName("Создание пользователя - проверка id")
    @AllureId("1809")
    void createUserAssertIdTest() {
        step("Создание нового пользовтеля, проверка ответа по id", () -> {
            steps.createUserAssertIdTest();
        });
    }

    @Test
    @DisplayName("Delete user")
    @AllureId("1811")
    void deleteUserTest() {
        step("Удаление пользователя", () -> {
            steps.deleteUserTest();
        });
    }

    @Test
    @DisplayName("Register user")
    @AllureId("1810")
    void registerUser() {
        step("Регистрация пользователя", () -> {
            steps.registerUser();
        });
    }

    @Test
    @DisplayName("Login User")
    @AllureId("1813")
    void loginUser() {
        step("Вход пользователя", () -> {
            steps.loginUser();
        });
    }
}
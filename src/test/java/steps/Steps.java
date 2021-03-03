package steps;

import model.Data;
import model.User;
import spec.Request;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Steps {

    public void assertResponseElementInListUsersTest() {
        given()
                .spec(Request.spec())// это так принято выносить все?
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .log().body()
                .body("data.last_name", hasItem("Lawson"));

    }

    public void assertResponseContainedInListResource() {
        Data data = given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .get("/unknown")
                .then()
                .statusCode(200)
                .body("data.color", hasItem("#C74375"))
                .extract().
                        as(Data.class);
    }

    public void createUserAssertIdTest() {
        given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().body()
                .body("id", notNullValue());
    }

    public void deleteUserTest() {
        given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204);
    }

    public void registerUser() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("pistol");

        given()
                .spec(Request.spec())
                //.contentType("application/json; charset=utf-8")
                .log().uri()
                .body(user)
                .when()
                .post("/register")
                .then()
                .statusCode(200)
                .log().body()
                .body("id", equalTo(4))
                .body("token", notNullValue());
    }

    public void loginUser() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("cityslicka");

        given()
                .spec(Request.spec())
                .log().uri()
                .body(user)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }
}
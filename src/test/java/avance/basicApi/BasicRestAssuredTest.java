package avance.basicApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class BasicRestAssuredTest {

    private final String BASE_URL = "https://todo.ly/api";
    @Test
    public void createProjectByApi(){

        JSONObject body = new JSONObject();
        body.put("Content", "Primer Proyecto Nuevo");
        body.put("Icon", 3);

        Response response=
        given()
                .contentType(ContentType.JSON)
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com","12345")
                .body(body.toString())
                .log()
                .all()
        .when()
                .post(BASE_URL+"/projects.json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(body.get("Content")))
                .body("Icon", equalTo(body.get("Icon")));

        int idProject = response.then().extract().path("Id");

        // update
        body.put("Content", "JSON Update");
        response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .body(body.toString())
                .log()
                .all().
                when()
                .put(BASE_URL+"/projects/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(body.get("Content")))
                .body("Icon", equalTo(body.get("Icon")));

        // read
        response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .log()
                .all().
                when()
                .get(BASE_URL+"/projects/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(body.get("Content")))
                .body("Icon", equalTo(body.get("Icon")));


        // delete
        response=given()
                .auth()
                .preemptive()
                .basic("upbapi@upbapi.com", "12345")
                .log()
                .all().
                when()
                .delete(BASE_URL+"/projects/"+idProject+".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(body.get("Content")))
                .body("Deleted", equalTo(true))
                .body("Icon", equalTo(body.get("Icon")));
    }
}

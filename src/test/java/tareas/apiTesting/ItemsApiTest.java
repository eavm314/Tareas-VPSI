package tareas.apiTesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ItemsApiTest {
    private final String BASE_URL = "https://todo.ly/api/items";
    private JSONObject baseResponse;

    @BeforeEach
    public void setup(){
        baseResponse = new JSONObject();
        String[] expectedKeys = {
                "Id", "Content", "ItemType", "Checked", "ProjectId", "ParentId",
                "Path", "Collapsed", "DateString", "DateStringPriority",
                "DueDate", "Recurrence", "ItemOrder", "Priority", "LastSyncedDateTime",
                "Children", "DueDateTime", "CreatedDate", "LastCheckedDate",
                "LastUpdatedDate", "Deleted", "Notes", "InHistory",
                "SyncClientCreationId", "DueTimeSpecified", "OwnerId"
        };

        for (String key : expectedKeys) {
            baseResponse.put(key, JsonComparator.IGNORED);
        }
    }

    @Test
    public void createItemByApi(){

        JSONObject body = new JSONObject();
        body.put("Content", "Nuevo Item desde Java");
        body.put("ProjectId", 4129669);

        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .auth()
                        .preemptive()
                        .basic("enriqueadhemar@gmail.com","eavm123")
                        .body(body.toString())
                        .log()
                        .all()
                        .when()
                        .post(BASE_URL+".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(body.get("Content")))
                .body("ProjectId", equalTo(body.get("ProjectId")));

        int idProject = response.then().extract().path("Id");

        // update
        body.put("Content", "Contenido de item actualizado");
        response=given()
                .auth()
                .preemptive()
                .basic("enriqueadhemar@gmail.com", "eavm123")
                .body(body.toString())
                .log()
                .all()
                .when()
                .put(BASE_URL+"/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(body.get("Content")))
                .body("ProjectId", equalTo(body.get("ProjectId")));

        // read
        response=given()
                .auth()
                .preemptive()
                .basic("enriqueadhemar@gmail.com", "eavm123")
                .log()
                .all()
                .when()
                .get(BASE_URL+"/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(body.get("Content")))
                .body("ProjectId", equalTo(body.get("ProjectId")));


        // delete
        response=given()
                .auth()
                .preemptive()
                .basic("enriqueadhemar@gmail.com", "eavm123")
                .log()
                .all()
                .when()
                .delete(BASE_URL+"/"+idProject+".json");

        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("Content", equalTo(body.get("Content")))
                .body("ProjectId", equalTo(body.get("ProjectId")))
                .body("Deleted", equalTo(true));
    }

    @Test
    public void createItemByApiWithJsonComparator(){

        JSONObject body = new JSONObject();
        body.put("Content", "Nuevo Item desde Java");
        body.put("ProjectId", 4129669);

        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .auth()
                        .preemptive()
                        .basic("enriqueadhemar@gmail.com","eavm123")
                        .body(body.toString())
                        .log()
                        .all()
                        .when()
                        .post(BASE_URL+".json");

        response.then()
                .log()
                .all()
                .statusCode(200);

        baseResponse.put("Content", body.get("Content"));
        baseResponse.put("ProjectId", body.get("ProjectId"));
        baseResponse.put("Deleted", false);

        Assertions.assertTrue(JsonComparator.compare(baseResponse, new JSONObject(response.getBody().asString())));

        int idProject = response.then().extract().path("Id");

        // update
        body.put("Content", "Contenido de item actualizado");
        response=given()
                .auth()
                .preemptive()
                .basic("enriqueadhemar@gmail.com", "eavm123")
                .body(body.toString())
                .log()
                .all()
                .when()
                .put(BASE_URL+"/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200);

        baseResponse.put("Content", body.get("Content"));

        Assertions.assertTrue(JsonComparator.compare(baseResponse, new JSONObject(response.getBody().asString())));

        // read
        response=given()
                .auth()
                .preemptive()
                .basic("enriqueadhemar@gmail.com", "eavm123")
                .log()
                .all()
                .when()
                .get(BASE_URL+"/"+idProject+".json");


        response.then()
                .log()
                .all()
                .statusCode(200);

        Assertions.assertTrue(JsonComparator.compare(baseResponse, new JSONObject(response.getBody().asString())));

        // delete
        response=given()
                .auth()
                .preemptive()
                .basic("enriqueadhemar@gmail.com", "eavm123")
                .log()
                .all()
                .when()
                .delete(BASE_URL+"/"+idProject+".json");

        response.then()
                .log()
                .all()
                .statusCode(200);

        baseResponse.put("Deleted", true);
        Assertions.assertTrue(JsonComparator.compare(baseResponse, new JSONObject(response.getBody().asString())));
    }
}

package tareas.ejercicios2P.apiTest.factory;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tareas.ejercicios2P.apiTest.config.Configuration;

import static io.restassured.RestAssured.given;

public class RequestDELETE implements IRequest {
    @Override
    public Response send(RequestInfo requestInfo) {
        RequestSpecification req = given()
                .headers(requestInfo.getHeaders());

        if (requestInfo.isBasicAuthNeeded()){
            req.auth()
                    .preemptive()
                    .basic(Configuration.user, Configuration.password);
        }

        Response response = req
                .log()
                .all().
                when()
                .delete(requestInfo.getUrl());
        response.then().log().all();
        return response;
    }
}
package tareas.ejercicios2P.apiTest.factory;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tareas.ejercicios2P.apiTest.config.Configuration;

import static io.restassured.RestAssured.given;

public class RequestGET implements IRequest {
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
                .get(requestInfo.getUrl());
        response.then().log().all();
        return response;
    }
}
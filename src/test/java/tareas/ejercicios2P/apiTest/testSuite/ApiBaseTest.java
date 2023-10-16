package tareas.ejercicios2P.apiTest.testSuite;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import tareas.ejercicios2P.apiTest.factory.RequestInfo;

public class ApiBaseTest {
    public String post ="post";
    public String put = "put";
    public String get ="get";
    public String delete ="delete";

    public RequestInfo requestInfo;
    public Response response;
    @BeforeEach
    public void before(){
        requestInfo = new RequestInfo();
    }

    @AfterEach
    public void after(){

    }

}
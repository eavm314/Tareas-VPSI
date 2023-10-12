package avance.basicApi;

import avance.RequestFactory.FactoryRequest;
import avance.RequestFactory.config.Configuration;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class UserItemTest extends TestBase{
    @Test
    public void createUserItem(){
        JSONObject bodyUser = new JSONObject();
        bodyUser.put("Email","email6@la.la");
        bodyUser.put("FullName","User 6");
        bodyUser.put("Password","123");

        createUser(Configuration.host + "/api/user.json", bodyUser, post);

        Configuration.user = bodyUser.getString("Email");
        Configuration.password = bodyUser.getString("Password");


        JSONObject bodyItem = new JSONObject();
        bodyItem.put("Content", "ItemCreado en una nueva cuenta");

        createItem(Configuration.host + "/api/items.json", bodyItem, post);


    }

    private void createUser(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200)
                .body("Email", equalTo(body.get("Email")))
                .body("FullName", equalTo(body.get("FullName")));
    }

    private void createItem(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200)
                .body("Content", equalTo(body.get("Content")));
    }
}

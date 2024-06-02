package RestAPI;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



import java.util.List;

public class RestAPITesting {


        @Test
        public void test_get_api_200() {

            RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
            // Get the RequestSpecification of the request to be sent to the server.
            RequestSpecification httpRequest = RestAssured.given();
            // specify the method type (GET) and the parameters if any.
            //In this case the request does not take any parameters
            Response response = httpRequest.request(Method.GET, "Books");
            // Print the status and message body of the response received from the server
            System.out.println("Status received => " + response.getStatusLine());
            System.out.println("Response=>" + response.prettyPrint());

            int statusCode = response.getStatusCode();

            // Assert that correct status code is returned.
            Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/,
                        "Correct status code returned");

            List<String> isbn = response.jsonPath().getList("books.isbn");
            System.out.println("elements "+isbn);
            System.out.println("no of elements "+isbn.size());
        }


        @Test
        public void UserRegistrationSuccessful()
        {
            RestAssured.baseURI ="https://api.restful-api.dev/objects";
            RequestSpecification request = RestAssured.given();
            JSONObject requestParams = new JSONObject();
            requestParams.put("name", "Test");

            JSONObject childObject = new JSONObject();
            childObject.put("year", "2024");
            childObject.put("price", "1900");
            childObject.put("CPU model", "Intel i9");
            childObject.put("Hard disk size", "1 TB");

            requestParams.put("data", childObject);
            request.body(requestParams.toJSONString());
            request.contentType(ContentType.JSON);
            System.out.println("str "+requestParams.toJSONString());

            Response response = request.post("");
            ResponseBody body = response.getBody();
            System.out.println(response.getStatusLine());
            System.out.println(body.asString());

            Assert.assertEquals( response.getStatusCode() /*actual value*/, 200 /*expected value*/,
                    "Correct status code returned");

        }

    @Test
    public void UserDelete()
    {
        RestAssured.baseURI ="https://api.restful-api.dev/objects";
        RequestSpecification request = RestAssured.given();
        String id = "ff8081818f8fd5f2018fb45f32533dd3";

        Response response = request.delete(id);
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.path("error").toString());


        /*Assert.assertEquals( response.getStatusCode() *//*actual value*//*, 200 *//*expected value*//*,
                "Correct status code returned");*/

        Assert.assertEquals( body.path("error").toString(),
                "Object with id = ff8081818f8fd5f2018fb45f32533dd3 has been deleted.");

    }


    }



package logic;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseRequestSender<T extends BaseRequestSender> {

    protected Response response;
    protected RequestSpecification requestSpecification;

    public BaseRequestSender() {
        requestSpecification = given();
    }

    public T queryParams(Map<String, String> params) {
        requestSpecification.queryParams(params);
        return (T) this;
    }

}

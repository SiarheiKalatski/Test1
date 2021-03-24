package logic;

import entity.answers.BaseAnswers;
import entity.answers.Item;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnswersRequestSender extends BaseRequestSender<AnswersRequestSender> {
    private Response response;

    public Response get(String site, String page, int pageSize, String order, String sort, String filter) {

        response = given().filter(new ResponseLoggingFilter()).filter(new RequestLoggingFilter()).queryParam("site", site)
                .queryParam("page", page).queryParam("pagesize", pageSize)
                .queryParam("order", order)
                .queryParam("sort", sort)
                .queryParam("filter", filter).get("/answers");
        return response;
    }

    public List<Item> getItemsList() {
        return Optional.ofNullable(response).map(i -> i.then().extract().as(BaseAnswers.class).getItems()).orElse(new ArrayList<>());
    }

}

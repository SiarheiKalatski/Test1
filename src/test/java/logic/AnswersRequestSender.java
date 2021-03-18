package logic;

import entity.Base;
import entity.Item;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


import java.util.ArrayList;
import java.util.List;

public class AnswersRequestSender {
    private Response response;

    public Response get(String site, String page, int pageSize, String order, String sort, String filter) {
        response = given().queryParam("site", site)
                .queryParam("page", page).queryParam("pagesize", pageSize)
                .queryParam("order", order)
                .queryParam("sort", sort)
                .queryParam("filter", filter).get("/answers");
        ;
        return response;
    }

    public List<Item> getItemsList() {
        if(response == null){
            return new ArrayList<>();
        }
        return response.then().extract().as(Base.class).getItems();
    }

}

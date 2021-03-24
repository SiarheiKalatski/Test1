package logic;

import entity.badges.Badge;
import entity.badges.BaseBadges;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BadgesRequestSender extends BaseRequestSender<BadgesRequestSender> {

    public Response get(String order, String sort, String site, String pageSize, String page) {
        response = requestSpecification.filter(new ResponseLoggingFilter()).filter(new RequestLoggingFilter())
                .queryParam("order", order)
                .queryParam("page", page)
                .queryParam("pagesize", pageSize)
                .queryParam("site", site)
                .queryParam("sort", sort).get("/badges");
        return response;
    }

    public List<Badge> getBadgeList() {
        return Optional.ofNullable(response).map(i -> i.then().extract().as(BaseBadges.class).getBadges()).orElse(new ArrayList<>());
    }

}

package tests;

import entity.badges.Badge;
import entity.badges.BaseBadges;
import io.restassured.response.Response;
import logic.BadgesRequestSender;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetBadgesTest {

    /*
     Stackoverflow API endpoint "/badges" test (Request method GET)

     1. Send GET request with base URI https://api.stackexchange.com/2.2
     and params page=1 pagesize=10 order=desc sort=rank site=stackoverflow max=gold
     (https://api.stackexchange.com/2.2/badges?max=gold&order=desc&page=1&pagesize=10&site=stackoverflow&sort=rank)

      Expected result: return json with an array of items (size = 10), where rank=gold and field "link" formed with a
      value of field "name" and value of field "badge_id",  status code = 200

    2. Send GET request with base URI https://api.stackexchange.com/2.2
     and params page=1 pagesize=10 order=desc sort=rank site=stackoverflow min=bronze
     (https://api.stackexchange.com/2.2/badges?min=bronze&order=desc&page=1&pagesize=10&site=stackoverflow&sort=rank)

     Expected result: return json with an array of items (size = 10), where rank=bronze and field "link" formed with a
     value of field "name" and value of field "badge_id", status code = 200

     3. Send GET request with base URI https://api.stackexchange.com/2.2
     and params page=1 pagesize=10 order=desc sort=rank site=stackoverflow max=silver min=silver
     (https://api.stackexchange.com/2.2/badges?min=silver&max=silver&order=desc&page=1&pagesize=10&site=stackoverflow&sort=rank)

      Expected result: return json with an array of items (size = 10), where rank=bronze and field "link" formed with a
      value of field "name" and value of field "badge_id", status code = 200
     */

    private final int statusCode = 200;
    private SoftAssert softAssert;
    private final int pageSize = 10;

    @BeforeMethod
    public void setup() {
        baseURI = "https://api.stackexchange.com/2.2";
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void afterMethod() {
        reset();
    }

    @DataProvider
    public Object[][] ranksParams() {
        Map<String, String> goldParam = new HashMap<>();
        goldParam.put("max", "gold");

        Map<String, String> silverParam = new HashMap<>();
        silverParam.put("max", "silver");
        silverParam.put("min", "silver");

        Map<String, String> bronzeParam = new HashMap<>();
        bronzeParam.put("min", "bronze");

        return new Object[][]{
                {goldParam, "gold"},
                {bronzeParam, "bronze"},
                {silverParam, "silver"}

        };
    }

    @Test(dataProvider = "ranksParams")
    public void badgesApiTest(Map<String, String> params, String rank) {

        BadgesRequestSender badgesRequestSender = new BadgesRequestSender();
        badgesRequestSender.queryParams(params).get("desc",
                "rank",
                "stackoverflow",
                "10",
                "1").
                then().assertThat().statusCode(statusCode);

        List<Badge> badgeList = badgesRequestSender.getBadgeList();
        softAssert.assertTrue(badgeList.size() <= pageSize, "Wrong size: " + badgeList.size());

        badgeList.stream().forEach(this::validateBadgeLink);

        badgeList.stream().forEach(i -> validateBadgeRank(i, rank));

        softAssert.assertAll();

    }

    private void validateBadgeLink(Badge badge) {

        softAssert.assertTrue(badge.getLink().contains(GetAnswersTest.stringConverter(badge.getName())) &&
                badge.getLink().contains(badge.getBadgeId().toString()) &&
                badge.getLink().contains("badges"), "Link not as expected" + badge);
    }

    private void validateBadgeRank(Badge badge, String rank) {
        softAssert.assertEquals(badge.getRank(), rank, "Rank not us expected: " + rank + "\n" + badge);
    }
}

import entity.Item;
import entity.Owner;
import logic.AnswersRequestSender;
import org.apache.commons.text.StringEscapeUtils;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import static io.restassured.RestAssured.*;

public class StackOverflowTest {

    private int statusCode = 200;
    private SoftAssert softAssert;
    private int pageSize = 10;

    @BeforeMethod
    public void setup() {
        baseURI = "https://api.stackexchange.com/2.2";
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void afterMethod() {
        reset();
    }

    @Test
    public void answersApiTest() throws UnsupportedEncodingException {

        AnswersRequestSender answersRequestSender = new AnswersRequestSender();
        answersRequestSender.get("stackoverflow", "1",
                pageSize, "desc", "activity", "default")
                .then().assertThat().statusCode(statusCode);

        List<Item> items = answersRequestSender.getItemsList();
        softAssert.assertTrue(items.size() <= pageSize);
        checkOwnerParameters(items);

        softAssert.assertAll();
    }

    private String stringConverter(String string) throws UnsupportedEncodingException {
        String normalString = StringEscapeUtils.unescapeHtml4(string).replaceAll("\\s*-\\s*|\\s+|_", "-")
                .replaceAll("-\\.-|-\\.|\\.-", "-").replaceAll("\\.", "-");
        return URLEncoder.encode(normalString, StandardCharsets.UTF_8.displayName()).toLowerCase();
    }

    private void checkOwnerParameters(List<Item> items) throws UnsupportedEncodingException {
        for (entity.Item item : items) {
            Owner owner = item.getOwner();
            softAssert.assertNotNull(owner);
            softAssert.assertTrue(owner.getLink().contains(owner.getUserId().toString()) &&
                    owner.getLink().contains(stringConverter(owner.getDisplayName())), owner.toString());
        }
    }
}

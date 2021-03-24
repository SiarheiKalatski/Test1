
package entity.answers;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import entity.Base;
import lombok.Data;

@Data
public class BaseAnswers extends Base {

    @SerializedName("items")
    private List<Item> items;


}

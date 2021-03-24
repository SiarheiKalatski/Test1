
package entity.badges;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import entity.Base;
import lombok.Data;

@Data
public class BaseBadges extends Base {

    @Expose
    @SerializedName("items")
    private List<Badge> badges;


}

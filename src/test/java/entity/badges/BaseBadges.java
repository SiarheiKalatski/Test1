
package entity.badges;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BaseBadges {

    @SerializedName("has_more")
    private Boolean hasMore;
    @Expose
    @SerializedName("items")
    private List<Badge> badges;
    @SerializedName("quota_max")
    private Long quotaMax;
    @SerializedName("quota_remaining")
    private Long quotaRemaining;

}

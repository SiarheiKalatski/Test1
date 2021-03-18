
package entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class Base {
    @Getter
    @Setter
    @SerializedName("backoff")
    private Long Backoff;
    @Getter
    @Setter
    @SerializedName("has_more")
    private Boolean HasMore;
    @Getter
    @Setter
    @SerializedName("items")
    private List<Item> Items;
    @Getter
    @Setter
    @SerializedName("quota_max")
    private Long QuotaMax;
    @Getter
    @Setter
    @SerializedName("quota_remaining")
    private Long QuotaRemaining;


}


package entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class Base {

    @SerializedName("backoff")
    @Setter
    @Getter
    private Long Backoff;
    @SerializedName("has_more")
    @Setter
    @Getter
    private Boolean HasMore;
    @SerializedName("items")
    @Setter
    @Getter
    private List<Item> Items;
    @SerializedName("quota_max")
    @Setter
    @Getter
    private Long QuotaMax;
    @SerializedName("quota_remaining")
    @Getter
    @Setter
    private Long QuotaRemaining;

}


package entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Base {

    @SerializedName("backoff")
    private Long Backoff;
    @SerializedName("has_more")
    private Boolean HasMore;
    @SerializedName("items")
    private List<Item> Items;
    @SerializedName("quota_max")
    private Long QuotaMax;
    @SerializedName("quota_remaining")
    private Long QuotaRemaining;

}

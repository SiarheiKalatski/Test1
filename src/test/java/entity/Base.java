package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Base {

    @SerializedName("backoff")
    private Long backoff;
    @SerializedName("has_more")
    private Boolean hasMore;
    @SerializedName("quota_max")
    private Long quotaMax;
    @SerializedName("quota_remaining")
    private Long quotaRemaining;
}

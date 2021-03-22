
package entity.badges;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Badge {

    @SerializedName("award_count")
    private Long awardCount;
    @SerializedName("badge_id")
    private Long badgeId;
    @SerializedName("badge_type")
    private String badgeType;
    @Expose
    private String link;
    @Expose
    private String name;
    @Expose
    private String rank;

}

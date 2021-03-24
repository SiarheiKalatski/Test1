
package entity.answers;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Owner {

    @SerializedName("accept_rate")
    private Long acceptRate;
    @SerializedName("display_name")
    private String displayName;
    @SerializedName("link")
    private String link;
    @SerializedName("profile_image")
    private String profileImage;
    @SerializedName("reputation")
    private Long reputation;
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("user_type")
    private String userType;
}

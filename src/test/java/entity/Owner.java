
package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
public class Owner {

    @SerializedName("accept_rate")
    @Setter
    @Getter
    private Long AcceptRate;
    @SerializedName("display_name")
    @Setter
    @Getter
    private String DisplayName;
    @SerializedName("link")
    @Setter
    @Getter
    private String Link;
    @SerializedName("profile_image")
    @Setter
    @Getter
    private String ProfileImage;
    @SerializedName("reputation")
    @Setter
    @Getter
    private Long Reputation;
    @SerializedName("user_id")
    @Setter
    @Getter
    private Long UserId;
    @SerializedName("user_type")
    @Setter
    @Getter
    private String UserType;
}

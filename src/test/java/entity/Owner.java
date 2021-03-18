
package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
public class Owner {

    @Getter
    @Setter
    @SerializedName("accept_rate")
    private Long AcceptRate;
    @Getter
    @Setter
    @SerializedName("display_name")
    private String DisplayName;
    @Getter
    @Setter
    @SerializedName("link")
    private String Link;
    @Getter
    @Setter
    @SerializedName("profile_image")
    private String ProfileImage;
    @Getter
    @Setter
    @SerializedName("reputation")
    private Long Reputation;
    @Getter
    @Setter
    @SerializedName("user_id")
    private Long UserId;
    @Getter
    @Setter
    @SerializedName("user_type")
    private String UserType;

}

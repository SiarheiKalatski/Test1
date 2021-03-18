
package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Owner {

    @SerializedName("accept_rate")
    private Long AcceptRate;
    @SerializedName("display_name")
    private String DisplayName;
    @SerializedName("link")
    private String Link;
    @SerializedName("profile_image")
    private String ProfileImage;
    @SerializedName("reputation")
    private Long Reputation;
    @SerializedName("user_id")
    private Long UserId;
    @SerializedName("user_type")
    private String UserType;
}

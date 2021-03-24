
package entity.answers;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Item {

    @SerializedName("answer_id")
    private Long answerId;
    @SerializedName("content_license")
    private String contentLicense;
    @SerializedName("creation_date")
    private Long creationDate;
    @SerializedName("is_accepted")
    private Boolean isAccepted;
    @SerializedName("last_activity_date")
    private Long lastActivityDate;
    @SerializedName("owner")
    private Owner owner;
    @SerializedName("question_id")
    private Long questionId;
    @SerializedName("score")
    private Long score;
}

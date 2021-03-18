
package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Item {

    @SerializedName("answer_id")
    private Long AnswerId;
    @SerializedName("content_license")
    private String ContentLicense;
    @SerializedName("creation_date")
    private Long CreationDate;
    @SerializedName("is_accepted")
    private Boolean IsAccepted;
    @SerializedName("last_activity_date")
    private Long LastActivityDate;
    @SerializedName("owner")
    private Owner Owner;
    @SerializedName("question_id")
    private Long QuestionId;
    @SerializedName("score")
    private Long Score;
}

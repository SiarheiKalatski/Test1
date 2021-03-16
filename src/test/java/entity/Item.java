
package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
public class Item {

    @SerializedName("answer_id")
    @Getter
    @Setter
    private Long AnswerId;
    @SerializedName("content_license")
    @Setter
    @Getter
    private String ContentLicense;
    @SerializedName("creation_date")
    @Setter
    @Getter
    private Long CreationDate;
    @SerializedName("is_accepted")
    @Setter
    @Getter
    private Boolean IsAccepted;
    @SerializedName("last_activity_date")
    @Setter
    @Getter
    private Long LastActivityDate;
    @SerializedName("owner")
    @Setter
    @Getter
    private Owner Owner;
    @SerializedName("question_id")
    @Setter
    @Getter
    private Long QuestionId;
    @SerializedName("score")
    @Setter
    @Getter
    private Long Score;
}

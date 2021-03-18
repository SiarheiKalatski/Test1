
package entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
public class Item {
    @Getter
    @Setter
    @SerializedName("answer_id")
    private Long AnswerId;
    @Getter
    @Setter
    @SerializedName("content_license")
    private String ContentLicense;
    @Getter
    @Setter
    @SerializedName("creation_date")
    private Long CreationDate;
    @Getter
    @Setter
    @SerializedName("is_accepted")
    private Boolean IsAccepted;
    @Getter
    @Setter
    @SerializedName("last_activity_date")
    private Long LastActivityDate;
    @Getter
    @Setter
    @SerializedName("owner")
    private Owner Owner;
    @Getter
    @Setter
    @SerializedName("question_id")
    private Long QuestionId;
    @Getter
    @Setter
    @SerializedName("score")
    private Long Score;

}

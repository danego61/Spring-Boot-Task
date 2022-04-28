package yusuf.task.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yusuf.task.model.base.DtoBase;

@Getter
@Setter
@AllArgsConstructor
public final class UserDto extends DtoBase {

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("userSurname")
    private String userSurname;

    @JsonProperty("userEmail")
    private String userEmail;

    @JsonProperty("userTelephone")
    private String userTelephone;

}

package yusuf.task.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yusuf.task.model.base.DtoBase;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddUserDto extends DtoBase {

    @JsonProperty("userName")
    @NotBlank
    @NotNull
    @Size(max = 50)
    private String userName;

    @JsonProperty("userSurname")
    @NotBlank
    @NotNull
    @Size(max = 50)
    private String userSurname;

    @JsonProperty("userEmail")
    @NotBlank
    @NotNull
    @Size(max = 50)
    @Email
    private String userEmail;

    @JsonProperty("userTelephone")
    @NotNull
    @Size(max = 11, min = 11)
    private String userTelephone;

}

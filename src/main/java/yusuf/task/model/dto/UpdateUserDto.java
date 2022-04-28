package yusuf.task.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yusuf.task.model.base.DtoBase;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto extends DtoBase {

    @JsonProperty("userName")
    @Size(max = 50, min = 3)
    private String userName;

    @JsonProperty("userSurname")
    @Size(max = 50, min = 3)
    private String userSurname;

}

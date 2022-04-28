package yusuf.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Response<T> {

    @JsonProperty("data")
    private final T data;

    @JsonProperty("message")
    private final String message;

    @JsonIgnore
    private final HttpStatus status;

    @JsonProperty("statusCode")
    public int getStatusCode() {
        return status.value();
    }

}

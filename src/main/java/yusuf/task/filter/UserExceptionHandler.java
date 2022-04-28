package yusuf.task.filter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import yusuf.task.exception.UserAlreadyExsistException;
import yusuf.task.model.ErrorResult;
import yusuf.task.model.Response;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = {UserAlreadyExsistException.class})
    public Response<ErrorResult> UserEmailAlreadyExsistHandler(UserAlreadyExsistException ex) {
        ErrorResult result = new ErrorResult("User email or telephone already exsist.", new String[]{ex.getMessage()});
        return new Response<>(result, "Error", HttpStatus.OK);
    }

}

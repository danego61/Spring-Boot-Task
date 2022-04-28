package yusuf.task.filter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import yusuf.task.exception.BadRequestException;
import yusuf.task.exception.NotFoundException;
import yusuf.task.model.ErrorResult;
import yusuf.task.model.Response;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public Response<ErrorResult> NotFoundHandler(NotFoundException ex) {
        ErrorResult result = new ErrorResult("Not found!", new String[]{ex.getMessage()});
        return new Response<>(result, "Error", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public Response<ErrorResult> BadRequestHandler(BadRequestException ex) {
        ErrorResult result = new ErrorResult("Bad request!", new String[]{ex.getMessage()});
        return new Response<>(result, "Error", HttpStatus.BAD_REQUEST);
    }

}

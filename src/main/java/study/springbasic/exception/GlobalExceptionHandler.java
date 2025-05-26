package study.springbasic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.springbasic.common.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundTodoWithIdException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundTodoWithIdException e){
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body(new ErrorResponse(e.getMessage(), 4000));
    }
}

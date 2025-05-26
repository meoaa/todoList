package study.springbasic.common;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private int code;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
        this.timestamp = LocalDateTime.now();
    }
}

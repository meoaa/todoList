package study.springbasic.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;

    public ApiResponse(T data) {
        this.success = true;
        this.data = data;
        this.message = "요청이 성공적으로 처리되었습니다.";
    }

    public ApiResponse(T data, String message) {
        this.success = true;
        this.data = data;
        this.message = message;
    }
}

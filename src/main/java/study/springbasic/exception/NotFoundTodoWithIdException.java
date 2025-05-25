package study.springbasic.exception;

public class NotFoundTodoWithIdException extends RuntimeException {
    public NotFoundTodoWithIdException() {
        super("해당 id와 일치하는 할 일이 존재하지 않습니다.");
    }

    public NotFoundTodoWithIdException(String message) {
        super(message);
    }

    public NotFoundTodoWithIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundTodoWithIdException(Throwable cause) {
        super(cause);
    }

    protected NotFoundTodoWithIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

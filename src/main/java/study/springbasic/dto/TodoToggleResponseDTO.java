package study.springbasic.dto;

import lombok.Data;
import study.springbasic.domain.Todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class TodoToggleResponseDTO {

    private boolean completed;
    private LocalDateTime updatedAt;

    public TodoToggleResponseDTO(Todo todo) {
        this.completed = todo.isCompleted();
        this.updatedAt = todo.getUpdatedAt();
    }
    public String getFormattedUpdatedAt(){
        return updatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getToggleButton(){
        return completed ? "미완료" : "완료";
    }

    public String getCompletedText(){
        return completed ? "완료" : "미완료";
    }
}

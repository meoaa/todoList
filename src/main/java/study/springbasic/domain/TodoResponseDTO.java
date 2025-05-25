package study.springbasic.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoResponseDTO {
    private Long id;
    private String title;
    private String completedText;
    private boolean completed;
    private LocalDateTime createdAt;

    public TodoResponseDTO(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.completed = todo.isCompleted();
        this.createdAt = todo.getCreatedAt();
    }

    public String getCompletedText(){
        return this.completed ? "완료" : "미완료";
    }
}

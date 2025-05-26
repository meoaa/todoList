package study.springbasic.dto;

import lombok.Data;
import study.springbasic.domain.Todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class TodoResponseDTO {
    private Long id;
    private String title;
    private String completedText;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public TodoResponseDTO(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.completed = todo.isCompleted();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
    }

    public String getCompletedText(){
        return this.completed ? "완료" : "미완료";
    }
    public String getToggleButton(){
        return this.completed ? "미완료" : "완료";
    }

    public String getFormattedCreatedAt(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return createdAt.format(formatter);
    }

    public String getFormattedUpdatedAt(){
        if(updatedAt != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return updatedAt.format(formatter);
        }else{
            return null;
        }
    }
}

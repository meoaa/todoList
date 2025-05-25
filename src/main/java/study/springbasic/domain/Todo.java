package study.springbasic.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Todo(String title) {
        this.title = title;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    public void changeTodoTitle(String title){
        this.title = title;
        this.updatedAt = LocalDateTime.now();
    }

    public void toggleComplete(){
        this.completed = !completed;
        this.updatedAt = LocalDateTime.now();
    }
}

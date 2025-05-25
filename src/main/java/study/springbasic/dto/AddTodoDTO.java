package study.springbasic.dto;

import lombok.Data;

@Data
public class AddTodoDTO {

    private String title;

    public AddTodoDTO(String title) {
        this.title = title;
    }
}

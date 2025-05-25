package study.springbasic.service;

import org.springframework.http.ResponseEntity;
import study.springbasic.domain.Todo;
import study.springbasic.domain.TodoResponseDTO;
import study.springbasic.dto.AddTodoDTO;
import study.springbasic.dto.UpdateTodoDTO;

import java.util.List;

public interface TodoService {

    TodoResponseDTO addTodo(AddTodoDTO dto);

    Todo searchById(long id);

    List<Todo> searchByTitle(String search);

    List<TodoResponseDTO> searchAll();

    void updateTodo(UpdateTodoDTO dto);

    void deleteTodo(long id);

    void toggleComplete(long id);
}

package study.springbasic.service;

import study.springbasic.domain.Todo;
import study.springbasic.dto.TodoResponseDTO;
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

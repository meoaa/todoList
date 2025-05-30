package study.springbasic.service;

import study.springbasic.dto.TodoResponseDTO;
import study.springbasic.dto.AddTodoDTO;
import study.springbasic.dto.TodoToggleResponseDTO;

import java.util.List;

public interface TodoService {

    TodoResponseDTO addTodo(AddTodoDTO dto);

    TodoResponseDTO searchById(long id);

//    List<Todo> searchByTitle(String search);

    List<TodoResponseDTO> searchAll();

//    void updateTodo(UpdateTodoDTO dto);

    TodoResponseDTO deleteTodo(long id);

    TodoToggleResponseDTO toggleComplete(long id);
}

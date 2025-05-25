package study.springbasic.service;

import study.springbasic.domain.Todo;
import study.springbasic.dto.UpdateTodoDTO;

import java.util.List;

public interface TodoService {

    void addTodo(Todo todo);

    Todo searchById(long id);

    List<Todo> searchByTitle(String search);

    List<Todo> searchAll();

    void updateTodo(UpdateTodoDTO dto);

    void deleteTodo(long id);

    void toggleComplete(long id);
}

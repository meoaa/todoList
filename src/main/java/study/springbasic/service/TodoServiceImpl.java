package study.springbasic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.springbasic.domain.Todo;
import study.springbasic.dto.TodoResponseDTO;
import study.springbasic.dto.AddTodoDTO;
import study.springbasic.dto.UpdateTodoDTO;
import study.springbasic.exception.NotFoundTodoWithIdException;
import study.springbasic.repository.TodoJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoJpaRepository repository;

    @Override
    @Transactional
    public TodoResponseDTO addTodo(AddTodoDTO dto) {
        Todo saved = repository.save(new Todo(dto.getTitle()));
        return new TodoResponseDTO(saved);
    }

    @Override
    public Todo searchById(long id) {
        return checkTodoById(id);
    }

    @Override
    public List<Todo> searchByTitle(String search) {
        return repository.findByTitle(search);
    }

    @Override
    public List<TodoResponseDTO> searchAll() {
        List<Todo> todos = repository.findAll();
        return todos.stream()
                .map(TodoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateTodo(UpdateTodoDTO dto) {
        Todo todo = checkTodoById(dto.getId());
        todo.changeTodoTitle(dto.getTitle());
    }

    @Override
    @Transactional
    public void deleteTodo(long id) {
        Todo todo = checkTodoById(id);
        repository.delete(todo);
    }

    @Override
    @Transactional
    public void toggleComplete(long id) {
        Todo todo = checkTodoById(id);
        todo.toggleComplete();
    }

    private Todo checkTodoById(long id) {
        return repository.findById(id).orElseThrow(NotFoundTodoWithIdException::new);
    }
}

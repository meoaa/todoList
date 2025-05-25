package study.springbasic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.springbasic.domain.Todo;
import study.springbasic.dto.UpdateTodoDTO;
import study.springbasic.exception.NotFoundTodoWithIdException;
import study.springbasic.repository.TodoJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoJpaRepository repository;

    @Override
    @Transactional
    public void addTodo(Todo todo) {
        repository.save(todo);
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
    public List<Todo> searchAll() {
        return repository.findAll();
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

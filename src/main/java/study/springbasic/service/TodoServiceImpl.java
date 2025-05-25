package study.springbasic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.springbasic.domain.Todo;
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
        return null;
    }

    @Override
    public List<Todo> searchByTitle(String search) {
        return List.of();
    }

    @Override
    public List<Todo> searchAll() {
        return List.of();
    }

    @Override
    @Transactional
    public void updateTodo(long id, String title) {

    }

    @Override
    @Transactional
    public void deleteTodo(long id) {

    }

    @Override
    @Transactional
    public void toggleComplete(long id) {

    }
}

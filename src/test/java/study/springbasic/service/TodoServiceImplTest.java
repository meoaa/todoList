package study.springbasic.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.springbasic.domain.Todo;
import study.springbasic.dto.UpdateTodoDTO;
import study.springbasic.exception.NotFoundTodoWithIdException;
import study.springbasic.repository.TodoJpaRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class TodoServiceImplTest {

    @Autowired
    private TodoJpaRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @Autowired
    private EntityManager em;

    @Test
    public void addTodoAndFind(){
        Todo todo = new Todo("study");
        todoService.addTodo(todo);

        Todo findTodo = todoService.searchById(todo.getId());
        assertEquals("study", findTodo.getTitle());

        assertThrows(NotFoundTodoWithIdException.class, () ->todoService.searchById(999L));
    }

    @Test
    public void updateTodoTitle(){
        Todo todo = new Todo("study");
        todoService.addTodo(todo);

        Todo findTodo = todoService.searchById(todo.getId());
        assertEquals("study", findTodo.getTitle());
        UpdateTodoDTO updateTodoDTO = new UpdateTodoDTO();
        updateTodoDTO.setId(todo.getId());
        updateTodoDTO.setTitle("eat");

        todoService.updateTodo(updateTodoDTO);
        em.flush();
        em.clear();

        Todo updateTodo = todoService.searchById(todo.getId());

        assertEquals("eat", updateTodo.getTitle());
    }

    @Test
    public void deleteTodo(){
        Todo todo = new Todo("study");
        todoService.addTodo(todo);

        Todo findTodo = todoService.searchById(todo.getId());
        assertEquals("study", findTodo.getTitle());

        todoService.deleteTodo(findTodo.getId());

        assertThrows(NotFoundTodoWithIdException.class, () -> todoService.searchById(findTodo.getId()));
    }

    @Test
    public void toggleComplete(){
        Todo todo = new Todo("study");
        todoService.addTodo(todo);

        Todo findTodo = todoService.searchById(todo.getId());
        assertFalse(findTodo.isCompleted());

        todoService.toggleComplete(todo.getId());
        em.flush();
        em.clear();

        Todo updateTodo = todoService.searchById(todo.getId());
        assertTrue(updateTodo.isCompleted());
    }
}
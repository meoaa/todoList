package study.springbasic.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.springbasic.domain.Todo;
import study.springbasic.dto.AddTodoDTO;
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
        AddTodoDTO dto = new AddTodoDTO("study");

        todoService.addTodo(dto);


        assertThrows(NotFoundTodoWithIdException.class, () ->todoService.searchById(999L));
    }

    @Test
    public void updateTodoTitle(){
        AddTodoDTO dto = new AddTodoDTO("study");

        todoService.addTodo(dto);


    }

    @Test
    public void deleteTodo(){

    }

    @Test
    public void toggleComplete(){

    }
}
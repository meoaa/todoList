package study.springbasic.service;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import study.springbasic.domain.Todo;
import study.springbasic.dto.AddTodoDTO;
import study.springbasic.dto.TodoResponseDTO;
import study.springbasic.dto.TodoToggleResponseDTO;
import study.springbasic.dto.UpdateTodoDTO;
import study.springbasic.exception.NotFoundTodoWithIdException;
import study.springbasic.repository.TodoJpaRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class TodoServiceImplTest {

    @Autowired
    private TodoJpaRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @Autowired
    private EntityManager em;

    @Test
    public void todoAddAndSearch(){
        AddTodoDTO addDto = new AddTodoDTO("sleep");
        TodoResponseDTO responseDTO = todoService.addTodo(addDto);

        TodoResponseDTO todo = todoService.searchById(responseDTO.getId());

        Assertions.assertThat(todo.getId()).isEqualTo(responseDTO.getId());
        Assertions.assertThat(todo.getTitle()).isEqualTo(responseDTO.getTitle());
    }

    @Test
    public void todoSearchByIdException(){
        Long nonexistentId = 999L;

        assertThrows(NotFoundTodoWithIdException.class,
                () -> todoService.searchById(nonexistentId));
    }

    @Test
    public void todoSearchAll(){
        AddTodoDTO addDto = new AddTodoDTO("sleep");
        AddTodoDTO addDto2 = new AddTodoDTO("study");

        todoService.addTodo(addDto);
        todoService.addTodo(addDto2);

        em.flush();
        em.clear();

        List<TodoResponseDTO> listDto = todoService.searchAll();

        Assertions.assertThat(2).isEqualTo(listDto.size());
    }

    @Test
    public void todoDelete(){
        AddTodoDTO dto = new AddTodoDTO("sleep");

        TodoResponseDTO responseDTO = todoService.addTodo(dto);
        Long id = responseDTO.getId();

        todoService.deleteTodo(id);

        em.flush();
        em.clear();

        List<TodoResponseDTO> listDto = todoService.searchAll();
        Assertions.assertThat(0).isEqualTo(listDto.size());
    }

    @Test
    public void todoToggleComplete(){
        AddTodoDTO dto = new AddTodoDTO("sleep");
        TodoResponseDTO responseDTO = todoService.addTodo(dto);

        TodoToggleResponseDTO todoToggleResponseDTO = todoService.toggleComplete(responseDTO.getId());

        em.flush();
        em.clear();

        assertTrue(todoToggleResponseDTO.isCompleted());
    }
}
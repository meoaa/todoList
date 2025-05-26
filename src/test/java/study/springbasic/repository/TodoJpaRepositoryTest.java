package study.springbasic.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import study.springbasic.domain.Todo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
@ActiveProfiles("test")
class TodoJpaRepositoryTest {

    @Autowired
    private TodoJpaRepository todoRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void testSaveAndFind(){
        Todo todo = new Todo("study");
        todoRepository.save(todo);

        Optional<Todo> found = todoRepository.findById(todo.getId());

        assertTrue(found.isPresent());
        assertEquals("study",found.get().getTitle());
    }

    @Test
    public void findAllTodoList(){
        Todo todo1 = new Todo("study");
        Todo todo2 = new Todo("sleep");

        todoRepository.save(todo1);
        todoRepository.save(todo2);

        em.flush();
        em.clear();

        List<Todo> allTodos = todoRepository.findAll();
        assertEquals(2, allTodos.size());
        assertTrue(allTodos.stream().anyMatch(t ->t.getTitle().equals("study")));
        assertTrue(allTodos.stream().anyMatch(t ->t.getTitle().equals("sleep")));
    }
    @Test
    public void removeTodo(){
        Todo todo1 = new Todo("study");
        Todo todo2 = new Todo("sleep");

        todoRepository.save(todo1);
        todoRepository.save(todo2);

        todoRepository.delete(todo1);
        em.flush();
        em.clear();

        List<Todo> allTodos = todoRepository.findAll();
        assertEquals(1, allTodos.size());
        assertTrue(allTodos.stream().anyMatch(t -> t.getTitle().equals("sleep")));
        assertFalse(allTodos.stream().anyMatch(t -> t.getTitle().equals("study")));
    }
}
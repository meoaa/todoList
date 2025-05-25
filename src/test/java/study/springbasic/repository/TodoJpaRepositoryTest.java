package study.springbasic.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import study.springbasic.domain.Todo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoJpaRepositoryTest {

    @Autowired
    private TodoJpaRepository todoRepository;

    @Test
    public void testSaveAndFind(){
        Todo todo = new Todo("잠자기");

        todoRepository.save(todo);

        Optional<Todo> found = todoRepository.findById(todo.getId());
        assertTrue(found.isPresent());
        assertEquals("잠자기",found.get().getTitle());
    }
}
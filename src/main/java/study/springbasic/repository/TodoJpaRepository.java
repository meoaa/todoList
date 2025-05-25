package study.springbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.springbasic.domain.Todo;

import java.util.List;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByTitle(String string);
}

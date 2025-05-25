package study.springbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.springbasic.domain.Todo;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
}

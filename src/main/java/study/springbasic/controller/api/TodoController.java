package study.springbasic.controller.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.springbasic.domain.TodoResponseDTO;
import study.springbasic.dto.AddTodoDTO;
import study.springbasic.service.TodoService;

@RestController
@AllArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/api/todo")
    public ResponseEntity<TodoResponseDTO> createTodo(@RequestBody AddTodoDTO dto){
        log.info("{}" , dto);
        TodoResponseDTO response = todoService.addTodo(dto);
        return ResponseEntity.ok(response);
    }
}

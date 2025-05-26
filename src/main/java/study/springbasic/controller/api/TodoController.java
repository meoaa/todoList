package study.springbasic.controller.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.springbasic.common.ApiResponse;
import study.springbasic.dto.TodoResponseDTO;
import study.springbasic.dto.AddTodoDTO;
import study.springbasic.dto.TodoToggleResponseDTO;
import study.springbasic.service.TodoService;

@RestController
@AllArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/api/todo")
    public ResponseEntity<ApiResponse<TodoResponseDTO>> createTodo(@RequestBody AddTodoDTO dto){
        log.info("{}" , dto);
        TodoResponseDTO response = todoService.addTodo(dto);
        return ResponseEntity.ok(new ApiResponse<>(response));
    }

    @DeleteMapping("/api/todo/{id}")
    public ResponseEntity<ApiResponse<TodoResponseDTO>> deleteTodo(@PathVariable int id){
        log.info("{}", id);
        TodoResponseDTO response = todoService.deleteTodo(id);
        return ResponseEntity.ok(new ApiResponse<>(response));
    }

    @PatchMapping("/api/todo/{id}")
    public ResponseEntity<ApiResponse<TodoToggleResponseDTO>> toggleTodo(
            @PathVariable int id){
        log.info("toggleTodo");
        TodoToggleResponseDTO response = todoService.toggleComplete(id);

        return ResponseEntity.ok(new ApiResponse<>(response));
    }
}

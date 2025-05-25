package study.springbasic.controller.view;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import study.springbasic.domain.TodoResponseDTO;
import study.springbasic.service.TodoService;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class HomeController {

    private final TodoService todoService;

    @GetMapping("/")
    public String mainPage(Model model){
        log.info("mainPage");
        List<TodoResponseDTO> dto = todoService.searchAll();
        model.addAttribute("todos", dto);

        return "index.html";
    }
}

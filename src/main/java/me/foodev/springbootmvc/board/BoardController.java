package me.foodev.springbootmvc.board;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("board")
    public String boardView (Model model){

        model.addAttribute("name","foodev");
        return "board"; //컨트롤러에서 문자열 반환은 뷰를 의미 한다.
    }
}

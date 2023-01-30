package hello.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller     //이 파일이 컨트롤러임을 명시해줌
public class BoardController {
    @GetMapping("hello")            //url hello에 접근하면 hello.html으로 접근하게해줌 인터넷에서 get 방식으로 넘어올때 어떻게 동작한다는 정의하기 위해 사용
    public String Hello(Model model){
        model.addAttribute("data", "hello!");       //html에 hello! 값이 들어간 data를 전달
        return "hello";
    }

    @GetMapping("home")
    public String Home(Model model){
        model.addAttribute("name", "nunu");      //html에 home sweet home 값이 들어간 home을 전달
        return "home";              //return (view name)
    }
}

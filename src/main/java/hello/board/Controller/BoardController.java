package hello.board.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller     //이 파일이 컨트롤러임을 명시해줌
public class BoardController {
    @GetMapping("hello")            //url hello에 접근하면 hello.html으로 접근하게해줌
    public String Hello(){
        return "hello";
    }
}

package hello.board.controller;

import hello.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberController{
    private final MemberService memberService;

    @Autowired          //@Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌
    public  MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}


package hello.board;

import hello.board.repository.MemberRepository;
import hello.board.repository.MemoryMemberRepository;
import hello.board.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {         //자바 코드로 직접 스프링 빈 등록
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

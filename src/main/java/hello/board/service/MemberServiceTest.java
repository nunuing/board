//package hello.board.service;
//
//import hello.board.domain.Member;
//import hello.board.repository.MemoryMemberRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MemberServiceTest {
//    MemberService memberService;
//    MemoryMemberRepository memberRepository;
//
//    @BeforeEach
//    public void beforeEach(){
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }
//
//    @AfterEach
//    public void afterEach(){
//        memberRepository.clearStore();
//    }
//
//    @Test
//    public void 회원가입() throws Exception {
//        Member member = new Member();
//        member.setId("join");
//        member.setName("test");
//        member.setPasswd("1234");
//
//        Long saveCode = memberService.join(member);
//
//        Member findMember = memberRepository.findByCode(saveCode).get();
//        assertEquals(member.getId(), findMember.getId());
//    }
//
//    @Test
//    public void 중복_회원_예외() throws Exception {
//        Member member1 = new Member();
//        member1.setId("join");
//        member1.setName("test");
//        member1.setPasswd("1234");
//
//        Member member2 = new Member();
//        member2.setId("join");
//        member2.setName("test");
//        member2.setPasswd("1234");
//
//        memberService.join(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//
//        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }
//}

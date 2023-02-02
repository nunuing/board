package hello.board.service;

import hello.board.domain.Member;
import hello.board.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;
    //회원 리포지토리의 코드가 회원 서비스 코드를 DI 가능하게 변경
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getCode();
    }

    //중복회원 조회
    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    //전체 회원 조회
    public Optional<Member> findOne(Long memberCode){
        return memberRepository.findByCode(memberCode);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}

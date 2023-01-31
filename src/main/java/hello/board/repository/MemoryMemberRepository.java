package hello.board.repository;

import hello.board.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {     //회원 가입
        member.setCode(++sequence);
        store.put(member.getCode(), member);
        return member;
    }

    @Override
    public Optional<Member> findByCode(Long code) {         //code(시스템에서 자동으로 부여)로 회원 조회
        return Optional.ofNullable(store.get(code));
    }

    @Override
    public List<Member> findAll() {                     //모든 회원 반환
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findById(String id) {       //ID로 회원 조회
        return store.values().stream().filter(member -> member.getId().equals(id)).findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {      //이름으로 회원 조회
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    public void clearStore(){
        store.clear();
    }

}

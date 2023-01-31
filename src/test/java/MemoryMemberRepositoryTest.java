import hello.board.domain.Member;
import hello.board.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    //회원 관련 기능이 잘 작동하는지 확인하기 위한 테스트 코드 작성
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){            //테스트가 끝날때마다 실행해줄 코드 -> DB 초기화
        repository.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("member1");
        member.setId("test_id");
        member.setPasswd("1234");

        //when
        repository.save(member);

        //then      -> 저장이 제대로 되었는지 확인 => 부여된 코드로
        Member result = repository.findByCode(member.getCode()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findById(){
        //given
        Member member1 = new Member();
        member1.setId("dbtest1");
        member1.setName("test1");
        member1.setPasswd("1234");
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("dbtest2");
        member2.setName("test2");
        member2.setPasswd("1234");
        repository.save(member2);

        //when
        Member result = repository.findById("dbtest1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setId("dbtest1");
        member1.setName("test1");
        member1.setPasswd("1234");
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("dbtest2");
        member2.setName("test2");
        member2.setPasswd("1234");
        repository.save(member2);

        //when
        Member result = repository.findByName("test1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setId("dbtest1");
        member1.setName("test1");
        member1.setPasswd("1234");
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("dbtest2");
        member2.setName("test2");
        member2.setPasswd("1234");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}

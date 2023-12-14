package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    /*
        테스트 메서드는 각 메서드에 의존관계가 없어야 함
     */

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메서드 종료 시 어떤 동작을 하기 위함
    public void afterEach() {
        repository.clearStore(); // 테스트 실행 후 저장소 초기화
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("코린이");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));

//        Assertions.assertEquals(member, null);
//        테스트 코드를 실행하게 된다면 빨간불이 들어옴 (null값이 들어와서 에러 발생)

//        Assertions.assertEquals(member, result); // JUnit 사용
//        Assertions.assertThat(member).isEqualTo(result); // assertJ 사용

        assertThat(member).isEqualTo(result); // option + 엔터 치고 static import하면 Assertions 생략 가능
    }

    @Test
    public void findByName() {
        Member mem1 = new Member();
        mem1.setName("Member1 입니다.");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setName("Member2 입니다.");
        repository.save(mem2);

        Member result = repository.findByName("Member1 입니다.").get(); // 초록불 들어옴(값이 일치하기 때문)
//        Member result = repository.findByName("Member2 입니다.").get(); // 빨간불 들어옴(값이 일치하지 않기 때문)

        assertThat(result).isEqualTo(mem1);
    }

    @Test
    public void findAll() {
        Member mem1 = new Member();
        mem1.setName("Member1 입니다.");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setName("Member2 입니다.");
        repository.save(mem2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}

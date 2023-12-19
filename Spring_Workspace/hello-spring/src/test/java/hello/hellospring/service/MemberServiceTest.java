package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach // 메서드 종료 시 어떤 동작을 하기 위함
    public void afterEach() {
        memberRepository.clearStore(); // 테스트 실행 후 저장소 초기화
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateMemberName() {
        // given
        Member member1 = new Member();
        member1.setName("spring");
        
        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디입니다.");
/*
        try {
            memberService.join(member2);
            fail("예외처리가 정상적으로 작동하지 않습니다.");
        } catch(IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디입니다.");
        }
*/
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
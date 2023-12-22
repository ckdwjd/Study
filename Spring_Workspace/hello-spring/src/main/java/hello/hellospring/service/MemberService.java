package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional // jpa를 사용 시 트랜잭션 처리를 해야한다
public class MemberService { // cmd + shift + t == 테스트 클래스 생성

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }



    /**
     * 회원가입
     */
    public long join(Member member) {
        // 중복 회원이 존재하면 안된다.
        // cmd + opt + v == 자동으로 리턴하는 단축키
        // Optional<Member> result = memberRepository.findByName(member.getName());
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).
                ifPresent(m -> { // null이 아니라 값이 존재하면.
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
    }

    /**
     * 전체회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    // @ (어노테이션) = 컴파일러에게 코드 작성 문법 에러를 체크하도록 정보를 제공,
    // 소프트웨어 개발툴이 빌드나 배치시 코드를 자동으로 생성할 수 있도록 정보 제공,
    // 실행시(런타임시)특정 기능을 실행하도록 정보를 제공

    MemberService memberService;

    @BeforeEach
    public void beforeEach() { // beforeEach = test 가 실행되기 전에 무조건 실행되는 메소드
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given (이러이러한 것들이 주어졌을 때)
        Member member = new Member(1L, "memberA" , Grade.VIP);

        // when (이렇게 하면)
        memberService.join(member);
        Member findmember = memberService.findMember(1L);

        // then (이렇게 된다)
        Assertions.assertThat(member).isEqualTo(findmember);
    }
}

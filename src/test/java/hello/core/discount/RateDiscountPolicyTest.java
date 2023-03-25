package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다") // 테스트 이름 표시하기
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP); // control + alt + v
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(1000);
        // static import 사용 시, static 멤버를 호출할 떄 클래스명을 생략할 수 있게 된다.
        // Assertions 에 static import 를 사용하여, 호출할 때 Assertions.assertThat 이 아닌 assertThat 으로 호출하는 것을 확인할 수 있다.
        // 코드를 간결하게 만드는 데 유용함
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        Member member = new Member(2L, "memberBASIC", Grade.BASIC); // control + alt + v
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(0);
    }
}
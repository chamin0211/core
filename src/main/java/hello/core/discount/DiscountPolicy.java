package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * @returnn 할인 대상 금액
     */
    int discount(Member member, int price); // 할인 대상 금액

}

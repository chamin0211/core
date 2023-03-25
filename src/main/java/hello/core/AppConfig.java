package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // 생성자 주입 / control + alt + m(인터페이스의 역할들을 한 눈에 볼 수 있게 된다.)
        // MemoryMemberRepository 객체(인스턴스)를 먼저 생성하여 MemberServiceImpl 을 생성할 때 생성자 매개 변수(파라미터)로 넘김
        // 쉽게 말해서, MemberServiceImpl 을 만들고 "내가 만든 MemberServiceImpl 은 MemoryMemberRepository 를 사용할거야" 라고 말하며,
        // 주입해주는 것이라고 이해할 수 있다.
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

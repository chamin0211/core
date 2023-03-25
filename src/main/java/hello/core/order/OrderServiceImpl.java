package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

//  private final MemberRepository memberRepository = new MemoryMemberRepository();
//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // DIP 원칙을 지키기 위해 인터페이스에만 의존하도록 변경
    // 하지만, 구현체가 없기 때문에 실행되지 않음. 따라서 OrderServiceImpl 과 DiscountPolicy 의 구현 객체를 대신 생성하고 주입해주어야 함.

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // final 은 무조건 값이 할당되어야 하기 때문에 사용 불가, 따라서 생성자가 기본 할당되어야 함

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

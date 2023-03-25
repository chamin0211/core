package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // final = 생성 시점에 초기화 되고, 다른 객체를 참조할 수 없다.(상속 역시 불가능), 한 번 값을 넣어두면 절대 바뀌지 않음
    // Static = 사용 시 메모리에 딱 한 번만 할달되기 때문에, 메모리를 효율적으로 사용 가능
    // final 과 static 을 같이 쓰면, final 로 고정된 값을 static 을 통해 메모리에 단 한 번 할당하여 쭉 사용할 수 있게 된다. (높은 효율성)
    private final MemberRepository memberRepository; // 다형성에 의해서 인터페이스인 MemberRepository 에서가 아닌,
                                                     // MemoryMemberRepository 에 있는 메소드들이 호출된다.
                                                     // MemberRepository 타입이며, MemoryMemberRepository 클래스의 객체인 memberRepository 를 생성한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

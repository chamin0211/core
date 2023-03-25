package hello.core.member;

public interface MemberRepository {

    void save(Member member); // 회원 저장

    Member findById(Long memberId); // 회원 Id로 회원 찾는 기능 +) 반환값이 Member
}

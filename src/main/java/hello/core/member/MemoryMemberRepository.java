package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    // Map = Key 와 Value 를 한 쌍으로 갖는 자료형이다.
    // Map 은 리스트나 배열처럼 순차적으로(sequential) 해당 요소 값을 구하지 않고 key를 통해 value를 얻는다.
    // 맵(Map)의 가장 큰 특징이라면 key 로 value 를 얻어낸다는 점이다.
    private static Map<Long, Member> store = new HashMap<>(); // 앞에는 Map, 뒤에는 HashMap 인 이유는 Map 은 인터페이스로, 객체 생성이 불가능(선언만 가능)
                                                              // 때문에 자식인 HashMap 으로 객체를 생성하는 것이다.
                                                              // Hashmap 은 본인의 메소드 외에 부모인 Map 의 메소드들을 강제 상속받는다.

    // 오버라이딩 = 부모 클래스(super class)에 존재하는 필드나 메서드를 자식 클래스(sub class)에서 재정의하여 사용하는 것.
    // 즉, 부모의 함수를 가져옴과 동시에 약간의 변형이 가능해짐
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

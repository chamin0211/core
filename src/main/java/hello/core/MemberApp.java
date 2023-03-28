package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//      MemberService memberService = new MemberServiceImpl();


        // ApplicationContext = 스프링 컨테이너 ,
        // AnnotationConfigApplicationContext = 자바 어노테이션을 이용한 클래스로부터 객체 설정 정보를 가져온다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // 스프링 컨테이너 생성
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // 자바 언어에서는 인터페이스도 빌드가 되면, .class 가 되기 때문에, 인터페이스와 클래스 구분없이 .class 로 사용 가능하다.

        Member member = new Member(1L, "memberA", Grade.VIP); // control + alt + v
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findmember.getName());// soutv = 위의 문장 복사
    }
}

package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 등록된 빈의 이름을 문자열 배열로 받아올 수 있다.
        for (String beanDefinitionName : beanDefinitionNames) { // 단축키 : iter = 리스트나 배열이 있으면, 그에 맞는 for 문을 자동 완성
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 등록된 빈의 이름을 문자열 배열로 받아올 수 있다.
        for (String beanDefinitionName : beanDefinitionNames) { // 단축키 : iter = 리스트나 배열이 있으면, 그에 맞는 for 문을 자동 완성
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            // ac.getBeanDefinition() : Bean 에 대한 meta data 정보들을 반환한다.
            // 코드에서는 스프링이 내부에서 사용하는 빈을 getRole() 로 구분하기 위해 사용함.


            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                // ROLE_APPLICATION : 일반적으로 사용자가 정의한 빈
                // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }
    }
}

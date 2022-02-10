package hello.core.autowired;

import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.Optional;

class TestBean {

    //의존관계 없으면 메서드 호출이 안됨
    @Autowired(required = false)
    public void setNoBean1(Member noBean1) {
        System.out.println("noBean1 = " + noBean1);
    }

    //의존관계 null일 때 메서드 호출은 되고, null 출력된다
    @Autowired
    public void setNoBean2(@Nullable Member noBean2) {
        System.out.println("noBean2 = " + noBean2);
    }

    @Autowired
    public void setNoBean3(Optional<Member> noBean3) {
        System.out.println("noBean3 = " + noBean3);
    }

}

package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig_S {

    //@Bean memberService -> memberRepository() -> MemoryMemberRepository()
    //@Bean orderService -> memberRepository() -> MemoryMemberRepository()
    //singleton 깨지는 거 아닌가?하고 궁금할 수 있음

    //예상결과(메소드 호출 순서는 보장하지 않음)
    //call AppConfig.memberService
    //call AppConfig..memberRepository
    //call AppConfig..memberRepository
    //call AppConfig.orderService
    //call AppConfig..memberRepository

    //실제 결과
    //call AppConfig.memberService
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    @Bean //스프링 컨테이너에 등록된다
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());

    }
    @Bean
    public DiscountPolicy discountPolicy(){

        return new RateDiscountPolicy();
    }
}

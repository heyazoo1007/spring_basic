package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder(){
        Member member= new Member(1L,"name", Grade.VIP);
        MemoryMemberRepository memberRepository= new MemoryMemberRepository();
        memberRepository.save(member);

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order= orderService.createOrder(member.getId(), "item1",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}

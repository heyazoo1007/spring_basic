package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //memorymemberrepo는 추상화,구현 모두애 의존(알고있다)
    private final MemberRepository memberRepository ; //구현 클래스 선언

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

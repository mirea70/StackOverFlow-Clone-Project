package PreProject.StackOverFlow.member.service;

import PreProject.StackOverFlow.exception.BusinessLogicException;
import PreProject.StackOverFlow.exception.ExceptionCode;
import PreProject.StackOverFlow.member.entity.Member;
import PreProject.StackOverFlow.member.mapper.MemberMapper;
import PreProject.StackOverFlow.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        verifyExists(member);
        Member savedMember = memberRepository.save(member);

        return savedMember;
    }

    public Member updateMember(Member member) {
        Member findMember = findVerifiedMember(member.getMemberId());

        Optional.ofNullable(member.getName())
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getLocation())
                .ifPresent(location -> findMember.setLocation(location));
        Optional.ofNullable(member.getProfile_image())
                .ifPresent(image -> findMember.setProfile_image(image));
        Optional.ofNullable(member.getJob())
                .ifPresent(job -> findMember.setJob(job));
        Optional.ofNullable(member.getAbout())
                .ifPresent(about -> findMember.setAbout(about));

        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId) {
        return findVerifiedMember(memberId);
    }

    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        Member member = optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return member;
    }

    private void verifyExists(Member member) {
        Optional<Member> check;
        check = memberRepository.findByEmail(member.getEmail());
        if (check.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
        check = memberRepository.findByName(member.getName());
        if (check.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
        check = memberRepository.findByPassword(member.getPassword());
        if (check.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }
    }
}
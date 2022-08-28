package PreProject.StackOverFlow.member.controller;

import PreProject.StackOverFlow.exception.BusinessLogicException;
import PreProject.StackOverFlow.member.dto.MemberDto;
import PreProject.StackOverFlow.member.entity.Member;
import PreProject.StackOverFlow.member.mapper.MemberMapper;
import PreProject.StackOverFlow.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Validated
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;



    @PostMapping("/login")
//     클라이언트에서 email과 password 전송
    public ResponseEntity login(MemberDto.Post post) {

        try {
//          모든 단계 성공 시 MEMBER 보드의 모든 데이터 전송
            Member checked = memberService.login_Service(memberMapper.memberPostToMember(post));
            return new ResponseEntity<>(memberMapper.memberToMemberResponse(checked), HttpStatus.OK);
        } catch (BusinessLogicException e) {
//          전송 된 email가 있는지 조회, 있으면 다음단계 / 없으면 'different' 전송
//          해당 email의 password와 1의 password가 일치하는지 검사, 일치하면 다음단계 / 없으면 'different' 전송
            return new ResponseEntity<>("different", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/join")
//      클라이언트에서 email, name, password, image 전송
    public ResponseEntity join(MemberDto.Post post) {
//      전송 된 email가 있는지 조회, 있다면 'diffferent' 전송 / 없으면 다음 단계 진행
        try {
//          전송된 email, name, password, image를 저장 및 'success' 출력
            memberService.join_Service(memberMapper.memberPostToMember(post));
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        } catch (BusinessLogicException e) {
            return new ResponseEntity<>("different",HttpStatus.BAD_REQUEST);
        }
    }
}
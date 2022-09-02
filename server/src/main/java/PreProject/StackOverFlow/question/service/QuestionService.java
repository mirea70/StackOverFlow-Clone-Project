package PreProject.StackOverFlow.question.service;


import PreProject.StackOverFlow.member.repository.MemberRepository;
import PreProject.StackOverFlow.question.entity.Question;
import PreProject.StackOverFlow.question.repository.QuestionRepository;
import PreProject.StackOverFlow.tag.repository.TagRepository;
import PreProject.StackOverFlow.voteMember.entity.VoteMember;
import PreProject.StackOverFlow.voteMember.repository.VoteMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;

    private final VoteMemberRepository voteMemberRepository;

    @Transactional
    public Question write_Service(Question question, Long memberId) {
        question.addMember(memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("로그인을 해주세요")
        ));
        return questionRepository.save(question);
    }

    @Transactional(readOnly = true)
    public Question read_Service(Long question_id) {
        Question finded = questionRepository.findById(question_id).orElseThrow(
                () -> new IllegalArgumentException("해당 질문 글을 찾을 수 없습니다."));
        finded.update_view_cnt();
        return finded;
    }

    public Page<Question> get_list_Service(int page, int size, String sort_Keyword, String search_Keyword) {
        String sortValue;

        Page<Question> response;
//        if(sort_Keyword.equals("Active")) {
//            // 각 Question의 modified와 answers의 modified들을 비교해 가장 나중의 것을 찾는다.
//            LocalDateTime activeDate;
//        }
        if(sort_Keyword.equals("Unanswered")) {
            response = questionRepository.findAllByAnswersIsNullAndTitleContaining(search_Keyword ,PageRequest.of(page - 1, size,
                    Sort.by("vote").descending()));
        } else {
            response = questionRepository.findByTitleContaining(search_Keyword ,PageRequest.of(page - 1, size,
                    Sort.by("questionId").descending()));
        }

        return response;
    }

    public void modify_Service(Question question) {
        // 수정 요청한 유저가 작성자 본인인지 확인한다.
        Question finded = findOne(question.getQuestionId());

        if (question.getMember().getMemberId() != finded.getMember().getMemberId()) {
            throw new IllegalArgumentException("작성자 본인이 아닙니다.");
        }

        // 본인이 맞으면 글을 수정한다.
        finded.update_Question(question.getTitle(), question.getContents());
//        questionRepository.save(finded);
    }

    public void delete_Service(Long questionId) {
        // 해당 게시글이 존재하는지 확인한다.
        Question finded = findOne(questionId);
        // 본인이 맞으면 글을 삭제한다.
        questionRepository.delete(finded);
    }

    public Question findOne(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(
                () -> new IllegalArgumentException("해당 질문 글을 찾을 수 없습니다."));
    }

    public void check_Service(Long questionId, Long memberId) {
        Question finded = findOne(questionId);
        // 채택 요청자가 작성자와 일치하는지 확인
        if(memberId != finded.getMember().getMemberId()) {
            throw new IllegalArgumentException("작성자만 채택이 가능합니다.");
        }
        // 채택은 한번만 가능해야한다.
        if(finded.getChecked() >= 1) {
            throw new IllegalArgumentException("채택은 한 번만 가능합니다.");
        }

        finded.check_Question();
        questionRepository.save(finded);
    }

    public void uncheck_Service(Long questionId, Long memberId) {
        Question finded = findOne(questionId);
        // 채택 취소 요청자가 작성자와 일치하는지 확인
        if(memberId != finded.getMember().getMemberId()) {
            throw new IllegalArgumentException("작성자만 채택 취소가 가능합니다.");
        }

        if(finded.getChecked() < 1) {
            throw new IllegalArgumentException("채택을 한 질문 글만 채택 취소가 가능합니다.");
        }

        finded.uncheck_Question();
        questionRepository.save(finded);
    }

    public void upVote_Service(Long questionId, Long memberId) {
        // 한 유저는 각 질문글에 한번씩만 투표 가능하다.
        Question finded = findOne(questionId);
        // Question에 저장된 질문을 투표한 회원들의 리스트 중, 요청한 memberId가 있다면 안된다.
        Optional<VoteMember> findVoteMember = voteMemberRepository.findByMemberId(memberId);

        if(findVoteMember.isEmpty()) {
            VoteMember newVoteMember = VoteMember.builder()
                    .memberId(memberId)
                    .question(finded)
                    .build();
            finded.up_vote(newVoteMember);
            voteMemberRepository.save(newVoteMember);
            questionRepository.save(finded);
        } else {
            throw new IllegalArgumentException("투표는 회원 당 한번만 가능합니다.");
        }
    }
    public void downVote_Service(Long questionId, Long memberId) {
        // 한 유저는 각 질문글에 한번씩만 투표 가능하다.
        Question finded = findOne(questionId);
        // Question에 저장된 질문을 투표한 회원들의 리스트 중, 요청한 memberId가 있다면 안된다.
        Optional<VoteMember> findVoteMember = voteMemberRepository.findByMemberId(memberId);

        if(findVoteMember.isEmpty()) {
            VoteMember newVoteMember = VoteMember.builder()
                                        .memberId(memberId)
                                        .question(finded)
                                        .build();
            finded.down_vote(newVoteMember);
            voteMemberRepository.save(newVoteMember);
            questionRepository.save(finded);
        } else {
            throw new IllegalArgumentException("투표는 회원 당 한번만 가능합니다.");
        }
    }
}

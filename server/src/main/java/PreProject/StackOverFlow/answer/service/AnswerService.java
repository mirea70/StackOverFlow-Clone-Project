package PreProject.StackOverFlow.answer.service;

import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.answer.repository.AnswerRepository;
import PreProject.StackOverFlow.member.repository.MemberRepository;
import PreProject.StackOverFlow.question.entity.Question;
import PreProject.StackOverFlow.question.repository.QuestionRepository;
import PreProject.StackOverFlow.voteMember.entity.VoteMember;
import PreProject.StackOverFlow.voteMember.repository.VoteMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    private final QuestionRepository questionRepository;

    private final MemberRepository memberRepository;

    private final VoteMemberRepository voteMemberRepository;

    public Answer answer_write_Service(Answer answer, Long questionId, Long memberId) {
        Question findedQuestion = questionRepository.findById(questionId).orElseThrow(
                () -> new IllegalArgumentException("해당 질문 글이 존재하지 않습니다.")
        );

        answer.addQuestion(findedQuestion);
        answer.addMember(memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")
        ));
        // 질문 게시글 데이터에도 해당 답변글을 포함시켜야 한다.
        findedQuestion.add_Answer(answer);

        return answerRepository.save(answer);
    }

    public void answer_modify_Service(Answer answer) {
        // 수정 요청한 유저가 작성자 본인인지 확인한다.
        Answer finded = find_Answer(answer.getAsnwerId());

        if (answer.getMember().getMemberId() != finded.getMember().getMemberId()) {
            throw new IllegalArgumentException("작성자 본인이 아닙니다.");
        }

        // 본인이 맞으면 글을 수정한다.
        finded.update_Answer(answer.getTitle(), answer.getContents());
        answerRepository.save(finded);
    }

    public void delete_Service(Long answerId, Long requestMemberId) {
        // 삭제할 답글이 존재하는지 확인한다.
        Answer finded_Answer = find_Answer(answerId);

        // 해당 게시글이 존재하는지 확인한다.
        Question finded_Question = questionRepository.findById(finded_Answer.getQuestion().getQuestionId()).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다."));

        // 삭제 요청한 유저가 작성자 본인인지 확인한다.
        if(requestMemberId != finded_Answer.getMember().getMemberId()) {
            throw new IllegalArgumentException("작성자 본인이 아닙니다.");
        }
        // 본인이 맞으면 글을 삭제한다.
        answerRepository.delete(finded_Answer);
    }

    public Answer find_Answer(Long answerId) {
        Answer findAnswer = answerRepository.findById(answerId).orElseThrow(
                () -> new IllegalArgumentException("해당 답글을 찾을 수 없습니다."));
        return findAnswer;
    }

    public void answer_UpVote_Service(Long answerId, Long memberId) {
        // 한 유저는 각 질문글에 한번씩만 투표 가능하다.
        Answer finded = find_Answer(answerId);
        // Answer에 저장된 질문을 투표한 회원들의 리스트 중, 요청한 memberId가 있다면 안된다.
        Optional<VoteMember> findVoteMember = voteMemberRepository.findByMemberId(memberId);

        if(findVoteMember.isEmpty()) {
            VoteMember newVoteMember = VoteMember.builder()
                    .memberId(memberId)
                    .answer(finded)
                    .build();
            finded.up_vote(newVoteMember);
            voteMemberRepository.save(newVoteMember);
            answerRepository.save(finded);
        } else {
            throw new IllegalArgumentException("투표는 회원 당 한번만 가능합니다.");
        }
    }

    public void answer_DownVote_Service(Long answerId, Long memberId) {
        // 한 유저는 각 질문글에 한번씩만 투표 가능하다.
        Answer finded = find_Answer(answerId);
        // Answer에 저장된 질문을 투표한 회원들의 리스트 중, 요청한 memberId가 있다면 안된다.
        Optional<VoteMember> findVoteMember = voteMemberRepository.findByMemberId(memberId);

        if(findVoteMember.isEmpty()) {
            VoteMember newVoteMember = VoteMember.builder()
                    .memberId(memberId)
                    .answer(finded)
                    .build();
            finded.down_vote(newVoteMember);
            voteMemberRepository.save(newVoteMember);
            answerRepository.save(finded);
        } else {
            throw new IllegalArgumentException("투표는 회원 당 한번만 가능합니다.");
        }
    }
}

package PreProject.StackOverFlow.answer.service;

import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.answer.repository.AnswerRepository;
import PreProject.StackOverFlow.question.entity.Question;
import PreProject.StackOverFlow.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    private final QuestionRepository questionRepository;

    public Answer answer_write_Service(Answer answer) {
        return answerRepository.save(answer);
    }

    public void delete_Service(Answer answer) {
        // 해당 게시글이 존재하는지 확인한다.
        Question finded_Question = questionRepository.findById(answer.getQuestion().getQuestion_id()).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다."));
        // 삭제할 답글이 존재하는지 확인한다.
        Answer finded_Answer = answerRepository.findById(answer.getAsnwer_id()).orElseThrow(
                () -> new IllegalArgumentException("해당 답글을 찾을 수 없습니다."));

        // 삭제 요청한 유저가 작성자 본인인지 확인한다.
        if(answer.getMember().getMember_id() != finded_Answer.getMember().getMember_id()) {
            throw new IllegalArgumentException("작성자 본인이 아닙니다.");
        }
        // 본인이 맞으면 글을 삭제한다.
        answerRepository.delete(finded_Answer);
    }
}

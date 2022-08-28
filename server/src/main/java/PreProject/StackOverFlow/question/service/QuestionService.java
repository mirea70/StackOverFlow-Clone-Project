package PreProject.StackOverFlow.question.service;


import PreProject.StackOverFlow.question.entity.Question;
import PreProject.StackOverFlow.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Question write_Service(Question question) {
        return questionRepository.save(question);
    }

    @Transactional(readOnly = true)
    public Question read_Service(Long question_id) {
        Question finded = questionRepository.findById(question_id).orElseThrow(
                () -> new IllegalArgumentException("해당 질문 글을 찾을 수 없습니다."));
        return finded;
    }

    public void modify_Service(Question question) {
        // 수정 요청한 유저가 작성자 본인인지 확인한다.
        Question finded = read_Service(question.getQuestion_id());

        if(question.getMember().getMember_Id() != finded.getMember().getMember_Id()) {
            throw new IllegalArgumentException("작성자 본인이 아닙니다.");
        }
        // 본인이 맞으면 글을 수정한다.
        finded.update_Question(question.getTitle(), question.getContents());
//        questionRepository.save(finded);
    }

    public void delete_Service(Question question) {
        // 삭제 요청한 유저가 작성자 본인인지 확인한다.
        Question finded = read_Service(question.getQuestion_id());

        if(question.getMember().getMember_Id() != finded.getMember().getMember_Id()) {
            throw new IllegalArgumentException("작성자 본인이 아닙니다.");
        }
        // 본인이 맞으면 글을 삭제한다.
        questionRepository.delete(finded);
    }
}

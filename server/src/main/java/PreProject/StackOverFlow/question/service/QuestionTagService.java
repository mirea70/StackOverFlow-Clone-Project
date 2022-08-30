package PreProject.StackOverFlow.question.service;

import PreProject.StackOverFlow.question.dto.QuestionTagDto;
import PreProject.StackOverFlow.question.entity.Question_Tag;
import PreProject.StackOverFlow.question.mapper.QuestionTagMapper;
import PreProject.StackOverFlow.question.repository.QuestionTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionTagService {

    private final QuestionTagRepository questionTagRepository;
    private final QuestionTagMapper questionTagMapper;

//    public Question_Tag addQuestionTag(QuestionTagDto.Post post){
//        System.out.println(post.getQuestionId() + ", " + post.getTagId());
//        Question_Tag questionTag = questionTagMapper.questionTagPostToQuestionTag(post);
//        System.out.println(questionTag.getTag());
//        System.out.println(questionTag.getQuestion());
//        return questionTagRepository.save(questionTag);
//    }
}

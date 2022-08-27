package PreProject.StackOverFlow.question.mapper;


import PreProject.StackOverFlow.question.dto.QuestionDto;
import PreProject.StackOverFlow.question.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question questionPostToQuestion(QuestionDto.Post post);

    Question questionPatchToQuestion(QuestionDto.Patch patch);

    QuestionDto.Response questionToQuestionResponse(Question question);

}

package PreProject.StackOverFlow.answer.mapper;

import PreProject.StackOverFlow.answer.dto.AnswerDto;
import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.question.dto.QuestionDto;
import PreProject.StackOverFlow.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostToAnswer(AnswerDto.Post post);
    Answer answerPatchToAnswer(AnswerDto.Patch patch);
    AnswerDto.Response answerToResponseDto(Answer answer);
    List<AnswerDto.Response> answersToResponseDtos(List<Answer> answers);
}

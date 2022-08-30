package PreProject.StackOverFlow.question.mapper;

import PreProject.StackOverFlow.question.dto.QuestionTagDto;
import PreProject.StackOverFlow.question.entity.Question_Tag;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionTagMapper {
    Question_Tag questionTagPostToQuestionTag(QuestionTagDto.Post post);
}

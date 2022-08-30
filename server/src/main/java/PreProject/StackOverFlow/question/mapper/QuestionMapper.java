package PreProject.StackOverFlow.question.mapper;


import PreProject.StackOverFlow.member.entity.Member;
import PreProject.StackOverFlow.question.dto.QuestionDto;
import PreProject.StackOverFlow.question.entity.Question;
import PreProject.StackOverFlow.question.entity.Question_Tag;
import PreProject.StackOverFlow.tag.entity.Tag;
import PreProject.StackOverFlow.tag.repository.TagRepository;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    default Question questionPostToQuestion(QuestionDto.Post post) {
        Question question = new Question();
        Member member = new Member();
        member.setMemberId(post.getMemberId());

        List<Question_Tag> questionTags = post.getQuestion_tags().stream()
                .map(postQuestionTags -> {
                    Question_Tag questionTag =
                            new Question_Tag(question, postQuestionTags.getTag());
                    return questionTag;
                }).collect(Collectors.toList());

        question.setQuestion_tags(questionTags);
        question.setTitle(post.getTitle());
        question.setContents(post.getContents());
        question.setMember(member);

        return question;
    }

    Question questionPatchToQuestion(QuestionDto.Patch patch);

    QuestionDto.Response questionToQuestionResponse(Question question);

    List<QuestionDto.Response> questionsToQuestionResponseDtos(List<Question> questions);
}

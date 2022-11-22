package PreProject.StackOverFlow.question.mapper;


import PreProject.StackOverFlow.answer.dto.AnswerDto;
import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.comment.dto.CommentDto;
import PreProject.StackOverFlow.comment.entity.Comment;
import PreProject.StackOverFlow.member.entity.Member;
import PreProject.StackOverFlow.question.dto.QuestionDto;
import PreProject.StackOverFlow.question.entity.Question;
import PreProject.StackOverFlow.question.entity.Question_Tag;
import PreProject.StackOverFlow.tag.entity.Tag;
import PreProject.StackOverFlow.tag.repository.TagRepository;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    Question questionPostToQuestion(QuestionDto.Post post);

//    default Question questionPostToQuestion(QuestionDto.Post post) {
//        Question question = new Question();
//        Member member = new Member();
//        member.setMemberId(post.getMemberId());
//
//        List<Question_Tag> questionTags = post.getQuestion_tags().stream()
//                .map(postQuestionTags -> {
//                    Question_Tag questionTag =
//                            new Question_Tag(question, postQuestionTags.getTag());
//                    return questionTag;
//                }).collect(Collectors.toList());
//
//        question.setQuestion_tags(questionTags);
//        question.setTitle(post.getTitle());
//        question.setContents(post.getContents());
//        question.setMember(member);
//
//        return question;
//    }

    default Question questionPatchToQuestion(QuestionDto.Patch patch){
        Question question = new Question();
        Member member = new Member();
        member.setMemberId(patch.getMemberId());

        question.setQuestionId(patch.getQuestionId());
        question.setTitle(patch.getTitle());
        question.setContents(patch.getContents());
        question.setMember(member);

        return question;
    }

    default public QuestionDto.Response questionToQuestionResponse(Question question) {
        if (question == null) {
            return null;
        } else {
            QuestionDto.Response.ResponseBuilder response = QuestionDto.Response.builder();
            response.questionId(question.getQuestionId());
            response.memberId(question.getMember().getMemberId());
            response.title(question.getTitle());
            response.contents(question.getContents());
            response.vote(question.getVote());
            response.view(question.getView());
            response.questionTagNames(question.getQuestionTagNames());
            response.answers(this.answerListToResponseList(question.getAnswers()));
            response.checked(question.getChecked());
            response.createdDate(question.getCreatedDate());
            response.modifiedDate(question.getModifiedDate());
            return response.build();
        }
    }

    default public List<QuestionDto.Response> questionsToQuestionResponseDtos(List<Question> questions) {
        if (questions == null) {
            return null;
        } else {
            List<QuestionDto.Response> list = new ArrayList(questions.size());
            Iterator var3 = questions.iterator();

            while(var3.hasNext()) {
                Question question = (Question)var3.next();
                list.add(this.questionToQuestionResponse(question));
            }

            return list;
        }
    }
    default public List<AnswerDto.Response> answerListToResponseList(List<Answer> list) {
        if (list == null) {
            return null;
        } else {
            List<AnswerDto.Response> list1 = new ArrayList(list.size());
            Iterator var3 = list.iterator();

            while(var3.hasNext()) {
                Answer answer = (Answer)var3.next();
                list1.add(this.answerToResponse(answer));
            }

            return list1;
        }
    }

    default public AnswerDto.Response answerToResponse(Answer answer) {
        if (answer == null) {
            return null;
        } else {
            AnswerDto.Response.ResponseBuilder response = PreProject.StackOverFlow.answer.dto.AnswerDto.Response.builder();
            response.title(answer.getTitle());
            response.contents(answer.getContents());
            response.vote(answer.getVote());
            response.answerId(answer.getAsnwerId());
            response.memberId(answer.getMember().getMemberId());
            response.questionId(answer.getQuestion().getQuestionId());
            response.comments(this.commentListToResponseList(answer.getComments()));
            response.createdDate(answer.getCreatedDate());
            response.modifiedDate(answer.getModifiedDate());
            return response.build();
        }
    }

    default public List<CommentDto.Response> commentListToResponseList(List<Comment> list) {
        if (list == null) {
            return null;
        } else {
            List<CommentDto.Response> list1 = new ArrayList(list.size());
            Iterator var3 = list.iterator();

            while(var3.hasNext()) {
                Comment comment = (Comment) var3.next();
                list1.add(this.commentToResponseDto(comment));
            }

            return list1;
        }
    }

    default public CommentDto.Response commentToResponseDto(Comment comment) {
        if (comment == null) {
            return null;
        } else {
            CommentDto.Response.ResponseBuilder response = CommentDto.Response.builder();
            response.commentId(comment.getCommentId());
            response.answerId(comment.getAnswer().getAsnwerId());
            response.memberId(comment.getMember().getMemberId());
            response.contents(comment.getContents());
            return response.build();
        }
    }

}

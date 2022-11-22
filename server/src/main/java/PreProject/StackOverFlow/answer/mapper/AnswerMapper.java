package PreProject.StackOverFlow.answer.mapper;

import PreProject.StackOverFlow.answer.dto.AnswerDto;
import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.comment.dto.CommentDto;
import PreProject.StackOverFlow.comment.entity.Comment;
import PreProject.StackOverFlow.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    default public Answer answerPostToAnswer(AnswerDto.Post post) {
        if (post == null) {
            return null;
        } else {
            Answer.AnswerBuilder answer = Answer.builder();
            answer.title(post.getTitle());
            answer.contents(post.getContents());
            return answer.build();
        }
    }
    default public Answer answerPatchToAnswer(AnswerDto.Patch patch) {
        Member member = new Member();
        member.setMemberId(patch.getMemberId());

        Answer.AnswerBuilder answer = Answer.builder();
        answer.asnwerId(patch.getAnswerId());
        answer.title(patch.getTitle());
        answer.contents(patch.getContents());
        answer.member(member);
        return answer.build();
    };
    default public AnswerDto.Response answerToResponseDto(Answer answer) {
        if (answer == null) {
            return null;
        } else {
            AnswerDto.Response.ResponseBuilder response = AnswerDto.Response.builder();
            response.answerId(answer.getAsnwerId());
            response.questionId(answer.getQuestion().getQuestionId());
            response.memberId(answer.getMember().getMemberId());
            response.title(answer.getTitle());
            response.contents(answer.getContents());
            response.vote(answer.getVote());
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
            response.createdDate(comment.getCreatedDate());
            response.modifiedDate(comment.getModifiedDate());
            return response.build();
        }
    }

    List<AnswerDto.Response> answersToResponseDtos(List<Answer> answers);
}

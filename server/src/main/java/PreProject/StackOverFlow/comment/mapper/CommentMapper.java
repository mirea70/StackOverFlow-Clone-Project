package PreProject.StackOverFlow.comment.mapper;

import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.comment.entity.Comment;
import PreProject.StackOverFlow.comment.dto.CommentDto;
import PreProject.StackOverFlow.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    default public Comment commentPostToComment(CommentDto.Post post) {
        if (post == null) {
            return null;
        } else {
            Answer answer = Answer.builder().asnwerId(post.getAnswerId()).build();
            Member member = Member.builder().memberId(post.getMemberId()).build();

            Comment.CommentBuilder comment = Comment.builder();
            comment.contents(post.getContents());
            comment.answer(answer);
            comment.member(member);
            return comment.build();
        }
    }
    default public Comment commentPatchToComment(CommentDto.Patch patch) {
        Answer answer = Answer.builder().asnwerId(patch.getAnswerId()).build();
        Member member = Member.builder().memberId(patch.getMemberId()).build();

        Comment.CommentBuilder comment = Comment.builder();
        comment.contents(patch.getContents());
        comment.commentId(patch.getCommentId());
        comment.answer(answer);
        comment.member(member);
        return comment.build();
    };
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
    List<CommentDto.Response> commentsToResponseDtos(List<Comment> comments);
}

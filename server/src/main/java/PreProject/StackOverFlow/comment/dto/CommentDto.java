package PreProject.StackOverFlow.comment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CommentDto {

    @ApiModel(value = "CommentResponseDto" ,description = "댓글 응답 모델")
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Response {
        @ApiModelProperty(notes = "댓글 식별번호", example = "1")
        private Long commentId;
        @ApiModelProperty(notes = "댓글 내용", example = "댓글 내용입니다")
        private String contents;
        @ApiModelProperty(notes = "댓글이 달린 답변의 식별번호", example = "1")
        private Long answerId;
        @ApiModelProperty(notes = "댓글 등록한 회원 식별번호", example = "2")
        private Long memberId;
    }

    @ApiModel(value = "CommentPostDto",description = "댓글 작성 모델")
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Post {

        @ApiModelProperty(value = "댓글 내용", required = true, example = "댓글 내용입니다")
        private String contents;
        @ApiModelProperty(value = "댓글 등록한 질문 식별번호", required = true, example = "1")
        private Long answerId;
        @ApiModelProperty(value = "댓글 등록한 회원 식별번호", required = true, example = "2")
        private Long memberId;
    }

    @ApiModel(value = "CommentPatchDto",description = "댓글 수정 모델")
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Patch {

        @ApiModelProperty(value = "댓글 식별번호", required = true, example = "1")
        private Long commentId;
        @ApiModelProperty(value = "댓글 내용", required = true, example = "댓글 내용입니다")
        private String contents;
        @ApiModelProperty(value = "댓글 등록한 질문 식별번호", required = true, example = "1")
        private Long answerId;
        @ApiModelProperty(value = "댓글 등록한 회원 식별번호", required = true, example = "2")
        private Long memberId;
    }
}

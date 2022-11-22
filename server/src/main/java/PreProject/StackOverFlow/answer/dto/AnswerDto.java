package PreProject.StackOverFlow.answer.dto;

import PreProject.StackOverFlow.comment.dto.CommentDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AnswerDto {

    @ApiModel(value = "AnswerResponseDto" ,description = "답변 응답 모델")
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Response {
        @ApiModelProperty(notes = "답변 식별번호", example = "1")
        private Long answerId;
        @ApiModelProperty(notes = "답변 제목", example = "답글 제목입니다")
        private String title;
        @ApiModelProperty(notes = "답변 내용", example = "답글 내용입니다")
        private String contents;
        @ApiModelProperty(notes = "답변 투표수", example = "0")
        private int vote;
        @ApiModelProperty(notes = "답변이 달린 질문의 식별번호", example = "1")
        private Long questionId;
        @ApiModelProperty(notes = "답변 등록한 회원 식별번호", example = "2")
        private Long memberId;
        @ApiModelProperty(value = "답변에 달린 댓글들", example = "배열 값으로 전달됩니다.")
        private List<CommentDto.Response> comments;
        @ApiModelProperty(value = "최초 생성 날짜", example = "2022-09-02 15:22:52.0")
        private LocalDateTime createdDate;
        @ApiModelProperty(value = "마지막 수정 날짜", example = "2022-09-02 15:22:52.0")
        private LocalDateTime modifiedDate;
    }

    @ApiModel(value = "AnswerPostDto",description = "답변 작성 모델")
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Post {

        @ApiModelProperty(value = "답변 제목", required = true, example = "답글 제목입니다")
        private String title;
        @ApiModelProperty(value = "답변 내용", required = true, example = "답글 내용입니다")
        private String contents;
        @ApiModelProperty(value = "답변 등록한 질문 식별번호", required = true, example = "1")
        private Long questionId;
        @ApiModelProperty(value = "답변 등록한 회원 식별번호", required = true, example = "2")
        private Long memberId;
    }

    @ApiModel(value = "AnswerPatchDto",description = "답변 수정 모델")
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Patch {

        @ApiModelProperty(value = "답변 식별번호", required = true, example = "1")
        private Long answerId;
        @ApiModelProperty(value = "답변 제목", required = true, example = "답글 제목입니다")
        private String title;
        @ApiModelProperty(value = "답변 내용", required = true, example = "답글 내용입니다")
        private String contents;
        @ApiModelProperty(value = "답변 수정한 질문 식별번호", required = true, example = "1")
        private Long questionId;
        @ApiModelProperty(value = "답변 수정한 회원 식별번호", required = true, example = "2")
        private Long memberId;
    }
}

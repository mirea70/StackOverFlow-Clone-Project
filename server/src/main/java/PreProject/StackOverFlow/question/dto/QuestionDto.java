package PreProject.StackOverFlow.question.dto;

import PreProject.StackOverFlow.member.entity.Member;
import PreProject.StackOverFlow.question.entity.Question_Tag;
import lombok.*;

import java.util.List;


@Getter
public class QuestionDto {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long questionId;

        private String title;

        private String contents;

        private int vote;

        private int view;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class PostA {
        private Long memberId;

        private String title;

        private String contents;

        private String questionTagNames;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Post {
        private Long memberId;

        private String title;

        private String contents;

        private List<Question_Tag> question_tags;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Patch {
        private Long questionId;

        private Member member;

        private String title;

        private String contents;
    }
}

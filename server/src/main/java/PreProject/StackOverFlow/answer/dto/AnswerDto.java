package PreProject.StackOverFlow.answer.dto;

import PreProject.StackOverFlow.member.entity.Member;
import PreProject.StackOverFlow.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class AnswerDto {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long answer_id;

        private String title;

        private String contents;

        private int vote;

        private Question question;

        private Member member;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Post {

        private String title;

        private String contents;

        private Question question;

        private Member member;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Patch {
        private Long answer_id;

        private String title;

        private String contents;

        private Question question;

        private Member member;
    }
}

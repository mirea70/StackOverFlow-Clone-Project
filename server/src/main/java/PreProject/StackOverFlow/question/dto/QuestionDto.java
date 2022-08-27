package PreProject.StackOverFlow.question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class QuestionDto {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Response {
        private Long question_id;

        private String title;

        private String contents;

        private int vote;

        private int view;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Post {
        private Long question_id;

        private Long member_id;

        private String title;

        private String contents;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Patch {
        private Long question_id;

        private Long member_id;

        private String title;

        private String contents;
    }
}

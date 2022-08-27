package PreProject.StackOverFlow.member.dto;

import PreProject.StackOverFlow.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        private String name;

        @Email
        @NotBlank
        private String email;

        @NotBlank
        private String password;
    }
    @Getter
    @AllArgsConstructor
    public static class Patch{
        private long memberId;

        @NotSpace
        private String name;

        private String location;

        private String profile_image;

        private String job;

        private String about;

        public void setMemberId(long memberId){
            this.memberId = memberId;
        }
    }
    @Getter
    @AllArgsConstructor
    public static class Response{
        private String name;
        private String email;
        private String location;
        private LocalDateTime actived_at;
        private LocalDateTime join_when;
        private String profile_imgae;
        private String job;
        private String about;
    }
}
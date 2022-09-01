package PreProject.StackOverFlow.comment.entity;

import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.basetime.BaseTimeEntity;
import PreProject.StackOverFlow.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "comment_id")
    private Long commentId;

    @Column(nullable = false)
    private String contents;

    // Comment : Answer 테이블 간의 N:1 연관관계 매핑을 위한 JPA 다대일 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    // Comment : Member 테이블 간의 N:1 연관관계 매핑을 위한 JPA 다대일 설정
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public void addMember(Member member) {
        this.member = member;
    }

    public void addAnswer(Answer answer) {this.answer = answer;}

    public void update_Comment(String contents) {
        this.contents = contents;
    }
}

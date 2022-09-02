package PreProject.StackOverFlow.answer.entity;

import PreProject.StackOverFlow.basetime.BaseTimeEntity;
import PreProject.StackOverFlow.comment.entity.Comment;
import PreProject.StackOverFlow.member.entity.Member;
import PreProject.StackOverFlow.question.entity.Question;
import PreProject.StackOverFlow.voteMember.entity.VoteMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "asnwer_id")
    private Long asnwerId;

    @Column(nullable = false)
    private String  title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private int vote;

    // Answer : Question 테이블 간의 N:1 연관관계 매핑을 위한 JPA 다대일 설정
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    // Answer : Member 테이블 간의 N:1 연관관계 매핑을 위한 JPA 다대일 설정
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Builder.Default
    @OneToMany(mappedBy = "answer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<VoteMember> voteMemberList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "answer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    public void addQuestion(Question question) {
        this.question = question;
    }

    public void addMember(Member member) {
        this.member = member;
    }

    public void update_Answer(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void up_vote(VoteMember voteMember) {
        this.vote +=1;
        this.voteMemberList.add(voteMember);
    }
    public void down_vote(VoteMember voteMember) {
        this.vote -=1;
        this.voteMemberList.add(voteMember);
    }

    public void add_Comment(Comment comment) {
        this.comments.add(comment);
    }
}

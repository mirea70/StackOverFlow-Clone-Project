package PreProject.StackOverFlow.question.entity;

import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.basetime.BaseTimeEntity;
import PreProject.StackOverFlow.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@DynamicInsert
@Builder
@Getter
public class Question extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long question_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    @Builder.Default
    private int vote = 0;

    @Column(nullable = false)
    @Builder.Default
    private int view = 0;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    // Tag : Question 테이블 간의 N:N 연관관계 매핑을 위한 JPA 일대다 설정
    @OneToMany(mappedBy = "question")
    private List<Question_Tag> question_tags = new ArrayList<>();

    // Answer : Question 테이블 간의 N:N 연관관계 매핑을 위한 JPA 일대다 설정
    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    public void update_Question(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void update_view_cnt() {
        view += 1;
    }
}

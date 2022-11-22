package PreProject.StackOverFlow.question.entity;

import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.basetime.BaseTimeEntity;
import PreProject.StackOverFlow.member.entity.Member;
import PreProject.StackOverFlow.voteMember.entity.VoteMember;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@DynamicInsert
@Builder
@Getter
@Setter
public class Question extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "question_id")
    private Long questionId;

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

    private String questionTagNames;

    @Builder.Default
    private int checked = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<VoteMember> voteMemberList = new ArrayList<>();

    // Tag : Question 테이블 간의 N:N 연관관계 매핑을 위한 JPA 일대다 설정
    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question_Tag> question_tags = new ArrayList<>();

    // Answer : Question 테이블 간의 N:1 연관관계 매핑을 위한 JPA 일대다 설정
    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public List<Answer> answers = new ArrayList<>();

//    @Column(columnDefinition = )
//    private LocalDateTime activeDate;
//    @CreatedDate
//    public LocalDateTime createdDate;
//
//    @LastModifiedDate
//    public LocalDateTime modifiedDate;
//
//    private LocalDateTime activeDate = createdDate;

    public void setQuestion_tags(List<Question_Tag> tags){
        this. question_tags = tags;
    }

    public void update_Question(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void addMember(Member member){
        this.member = member;
    }

    public void update_view_cnt() {
        view += 1;
    }

    public void add_Answer(Answer answer) {
        this.answers.add(answer);
    }

    public void check_Question() {
        this.checked +=1;
    }

    public void uncheck_Question() {
        this.checked -= 1;
    }

    public void up_vote(VoteMember voteMember) {
        this.vote +=1;
        this.voteMemberList.add(voteMember);
    }
    public void down_vote(VoteMember voteMember) {
        this.vote -=1;
        this.voteMemberList.add(voteMember);
    }
}

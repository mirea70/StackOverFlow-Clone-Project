package PreProject.StackOverFlow.voteMember.entity;

import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.basetime.BaseTimeEntity;
import PreProject.StackOverFlow.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class VoteMember extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private Long voteId;

    private Long memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID")
    Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANSWER_ID")
    Answer answer;

    public void addQuestion(Question question){
        this.question = question;
    }

    public void addMemberId(Long memberId) {
        this.memberId = memberId;
    }
}

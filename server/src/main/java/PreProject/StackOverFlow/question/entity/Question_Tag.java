package PreProject.StackOverFlow.question.entity;

import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.tag.entity.Tag;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Question_Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_tag_id;

    // 테이블 명세서에 created_at 이 여기 왜만들었었는지 질문하기

    // Tag : Question 테이블 간의 N:N 연관관계 매핑을 위한 JPA 다대일 설정
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    // Tag : Question 테이블 간의 N:N 연관관계 매핑을 위한 JPA 다대일 설정
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TAG_ID")
    private Tag tag;
}

package PreProject.StackOverFlow.question.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Question_Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_tag_id;

    @Column(nullable = false)
    private Long question_id;

    @Column(nullable = false)
    private Long tag_id;

    // 테이블 명세서에 created_at 이 여기 왜만들었었는지 질문하기
}

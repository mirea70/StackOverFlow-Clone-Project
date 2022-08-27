package PreProject.StackOverFlow.answer.entity;

import PreProject.StackOverFlow.basetime.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Answer extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(unique = true)
    private Long asnwer_id;

    @Column(nullable = false)
    private Long question_id;

    @Column(nullable = false)
    private Long member_id;

    @Column(nullable = false)
    private String  title;

    @Column(nullable = false)
    private String contents;
}

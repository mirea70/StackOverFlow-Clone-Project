package PreProject.StackOverFlow.question.entity;

import PreProject.StackOverFlow.basetime.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

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
    private Long member_id;

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

    public void update_Question(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}

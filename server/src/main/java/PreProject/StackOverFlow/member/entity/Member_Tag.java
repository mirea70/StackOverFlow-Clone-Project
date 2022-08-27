package PreProject.StackOverFlow.member.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member_Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_tag_id;

    @Column(nullable = false)
    private Long member_id;

    @Column(nullable = false)
    private Long tag_id;

    // 용도 질문하기
    @Column(nullable = false)
    private int answer_cnt = 0;
}

package PreProject.StackOverFlow.member.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member_Tag {

    // Member와 Tag간의 연관관계가 왜 필요한지 만들면서 다시생각하니 이해가 안가네요. 설명 부탁드립니다.
    // 만약 이렇게될 경우, Member 테이블에 생기는 member_tag의 tag_id를 저장할 때,
    // Qustion 테이블에 생기는 question_tag의 tag_id랑 어떻게 매칭하게될건지???

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

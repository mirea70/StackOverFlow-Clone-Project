package PreProject.StackOverFlow.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @Column
    private String location;

    @Column(nullable = false)
    private LocalDateTime active_at;    // modified_at

    @Column(nullable = false, updatable = false)
    private LocalDateTime join_when;    // created_at

    @Column
    private String profile_image;

    @Column
    private String job;

    @Column
    private String about;
}
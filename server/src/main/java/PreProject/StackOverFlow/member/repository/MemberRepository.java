package PreProject.StackOverFlow.member.repository;


import PreProject.StackOverFlow.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByPassword(String password);
    Optional<Member> findByName(String name);
}
package PreProject.StackOverFlow.voteMember.repository;

import PreProject.StackOverFlow.voteMember.entity.VoteMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteMemberRepository extends JpaRepository<VoteMember, Long> {
    Optional<VoteMember> findByMemberId(Long memberId);
}

package PreProject.StackOverFlow.comment.repository;

import PreProject.StackOverFlow.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

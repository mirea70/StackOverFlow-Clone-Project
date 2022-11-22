package PreProject.StackOverFlow.comment.service;

import PreProject.StackOverFlow.answer.entity.Answer;
import PreProject.StackOverFlow.answer.repository.AnswerRepository;
import PreProject.StackOverFlow.comment.repository.CommentRepository;
import PreProject.StackOverFlow.comment.entity.Comment;
import PreProject.StackOverFlow.member.repository.MemberRepository;
import PreProject.StackOverFlow.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final AnswerRepository answerRepository;

    private final MemberRepository memberRepository;

    public Comment comment_write_Service(Comment comment, Long answerId, Long memberId) {
        Answer findedAnswer = answerRepository.findById(answerId).orElseThrow(
                () -> new IllegalArgumentException("해당 답변이 존재하지 않습니다.")
        );

        comment.addAnswer(findedAnswer);
        comment.addMember(memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")
        ));
        // 댓글이 달릴 답변 데이터에도 해당 댓글을 포함시켜야 한다.
        findedAnswer.add_Comment(comment);
//        answerRepository.save(findedAnswer);
        Question findedQuestion = findedAnswer.getQuestion();

        return commentRepository.save(comment);
    }

    public void comment_modify_Service(Comment comment) {
        // 수정 요청한 유저가 작성자 본인인지 확인한다.
        Comment finded = find_Comment(comment.getCommentId());

        if (comment.getMember().getMemberId() != finded.getMember().getMemberId()) {
            throw new IllegalArgumentException("작성자 본인이 아닙니다.");
        }

        // 본인이 맞으면 글을 수정한다.
        finded.update_Comment(comment.getContents());
        commentRepository.save(finded);
    }

    public void delete_Service(Long commentId, Long requestMemberId) {
        // 삭제할 댓글이 존재하는지 확인한다.
        Comment finded_Comment = find_Comment(commentId);

        // 댓글 단 답변이 존재하는지 확인한다.
        Answer finded_Answer = answerRepository.findById(finded_Comment.getAnswer().getAsnwerId()).orElseThrow(
                () -> new IllegalArgumentException("해당 답변을 찾을 수 없습니다."));

        // 삭제 요청한 유저가 작성자 본인인지 확인한다.
        if(requestMemberId != finded_Comment.getMember().getMemberId()) {
            throw new IllegalArgumentException("작성자 본인이 아닙니다.");
        }
        // 본인이 맞으면 글을 삭제한다.
        commentRepository.delete(finded_Comment);
    }

    public Comment find_Comment(Long commentId) {
        Comment findComment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글을 찾을 수 없습니다."));
        return findComment;
    }
}

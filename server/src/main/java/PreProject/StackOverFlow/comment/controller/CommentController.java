package PreProject.StackOverFlow.comment.controller;

import PreProject.StackOverFlow.comment.dto.CommentDto;
import PreProject.StackOverFlow.comment.entity.Comment;
import PreProject.StackOverFlow.comment.mapper.CommentMapper;
import PreProject.StackOverFlow.comment.service.CommentService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ApiResponses({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    private final CommentMapper commentMapper;

    @ApiOperation(value = "댓글 등록", notes = "등록된 댓글 데이터 반환", response = CommentDto.Response.class)
    @PostMapping("/write")
    public ResponseEntity answer_write(@RequestBody CommentDto.Post commentPost) {
        Comment writed = commentService.comment_write_Service(commentMapper.commentPostToComment(commentPost), commentPost.getAnswerId(), commentPost.getMemberId());
        return new ResponseEntity<>(commentMapper.commentToResponseDto(writed), HttpStatus.CREATED);
    }

    @ApiOperation(value = "댓글 수정", notes = "댓글 데이터 수정", response = String.class)
    @PatchMapping("/modify")
    public ResponseEntity answer_modify(@RequestBody CommentDto.Patch commentPatch) {
        commentService.comment_modify_Service(commentMapper.commentPatchToComment(commentPatch));

        return new ResponseEntity<>("수정이 완료되었습니다.", HttpStatus.OK);
    }

    @ApiOperation(value = "답글 삭제", notes = "1개 답글 삭제")
    @ApiImplicitParam(name = "commentId", value = "답글 식별번호", required = true)
    @DeleteMapping("/{commentId}")
    public ResponseEntity answer_delete(@PathVariable Long commentId,
                                        @ApiParam(value = "댓글 등록한 회원식별번호", required = true, example = "2")
                                        @RequestParam Long memberId) {
        commentService.delete_Service(commentId, memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "댓글 조회", notes = "1개 댓글 데이터 반환", response = CommentDto.Response.class)
    @ApiImplicitParam(name = "commentId", value = "댓글 식별번호", required = true)
    @GetMapping("{commentId}")
    public ResponseEntity find_answer(@PathVariable Long commentId) {
        Comment finded = commentService.find_Comment(commentId);
        return new ResponseEntity<>(commentMapper.commentToResponseDto(finded), HttpStatus.OK);
    }
}

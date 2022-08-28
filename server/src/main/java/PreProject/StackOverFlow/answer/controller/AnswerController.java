package PreProject.StackOverFlow.answer.controller;

import PreProject.StackOverFlow.answer.dto.AnswerDto;
import PreProject.StackOverFlow.answer.mapper.AnswerMapper;
import PreProject.StackOverFlow.answer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;

    private final AnswerMapper answerMapper;

    @PostMapping
    public ResponseEntity answer_write(@RequestBody AnswerDto.Post post) {
        answerService.answer_write_Service(answerMapper.answerPostToAnswer(post));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity answer_delete(@RequestBody AnswerDto.Patch delete) {
        answerService.delete_Service(answerMapper.answerPatchToAnswer(delete));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

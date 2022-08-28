package PreProject.StackOverFlow.question.controller;

import PreProject.StackOverFlow.question.dto.QuestionDto;
import PreProject.StackOverFlow.question.entity.Question;
import PreProject.StackOverFlow.question.mapper.QuestionMapper;
import PreProject.StackOverFlow.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    private final QuestionMapper mapper;

    @PostMapping
    public ResponseEntity write(@RequestBody QuestionDto.Post post) {

       Question writed = questionService.write_Service(mapper.questionPostToQuestion(post));

       return new ResponseEntity<>(mapper.questionToQuestionResponse(writed), HttpStatus.CREATED);
    }

    @GetMapping("/{question_id}")
    public ResponseEntity read(@PathVariable Long question_id) {
        Question finded = questionService.read_Service(question_id);
        return new ResponseEntity<>(mapper.questionToQuestionResponse(finded), HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity get_list(@RequestParam int page, @RequestParam int size) {
        return null;
    }

    @PatchMapping
    public ResponseEntity modify(@RequestBody QuestionDto.Patch patch) {
        questionService.modify_Service(mapper.questionPatchToQuestion(patch));

        return new ResponseEntity<>("수정이 완료되었습니다.", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody QuestionDto.Patch delete) {
        questionService.delete_Service(mapper.questionPatchToQuestion(delete));
        return new ResponseEntity<>("삭제가 완료되었습니다.", HttpStatus.NO_CONTENT);
    }
}

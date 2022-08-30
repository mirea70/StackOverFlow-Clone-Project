package PreProject.StackOverFlow.question.controller;

import PreProject.StackOverFlow.dto.MultiResponseDto;
import PreProject.StackOverFlow.member.service.MemberService;
import PreProject.StackOverFlow.question.dto.QuestionDto;
import PreProject.StackOverFlow.question.entity.Question;
import PreProject.StackOverFlow.question.entity.Question_Tag;
import PreProject.StackOverFlow.question.mapper.QuestionMapper;
import PreProject.StackOverFlow.question.service.QuestionService;
import PreProject.StackOverFlow.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper mapper;
    private final TagRepository tagRepository;

    private final MemberService memberService;

    // 질문 등록
    @PostMapping("/write")
    public ResponseEntity write(@RequestBody QuestionDto.PostA postA) {
        // postA에서 String 으로 받은 tag 이름들 split해서 tagRepository를 통해 각각 Tag객체 얻어온 후
        // QuestionDto.Post 객체로 변환하여 QuestionMapper를 통해 Question으로 변환.
        // QuestionMapper에 questionPostToQuestion()메서드 임의로 정의하였음.
        Question question = new Question();
        List<Question_Tag> tags = Arrays.stream(postA.getQuestionTagNames().split(" "))
                .map(str -> tagRepository.findByName(str))
                .map(tag -> new Question_Tag(question, tag))
                .collect(Collectors.toList());
        QuestionDto.Post post = new QuestionDto.Post(
                postA.getMemberId(), postA.getTitle(), postA.getContents(), tags);

        Question writed = questionService.write_Service(mapper.questionPostToQuestion(post));

        return new ResponseEntity<>(mapper.questionToQuestionResponse(writed), HttpStatus.CREATED);
    }

    @GetMapping("/{question_id}")
    public ResponseEntity read(@PathVariable Long questionId) {
        Question finded = questionService.read_Service(questionId);
        return new ResponseEntity<>(mapper.questionToQuestionResponse(finded), HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity get_list(@RequestParam("page") int page) {
        Page<Question> page_list = questionService.get_list_Service(page);
        List<Question> finded_list = page_list.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(mapper.questionsToQuestionResponseDtos(finded_list), page_list)
                , HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity modify(@RequestBody QuestionDto.Patch patch) {

        questionService.modify_Service(mapper.questionPatchToQuestion(patch));

        return new ResponseEntity<>("수정이 완료되었습니다.", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("questionId") Long questionId) {
        questionService.delete_Service(questionId);
        return new ResponseEntity<>("삭제가 완료되었습니다.", HttpStatus.NO_CONTENT);
    }
}

package com.llm.llm_knowledge.controller;

import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.AnswerRecordDTO;
import com.llm.llm_knowledge.entity.AnswerRecord;
import com.llm.llm_knowledge.exception.BizException;
import com.llm.llm_knowledge.service.AnswerRecordService;
import com.llm.llm_knowledge.vo.AnswerRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("ans")
public class AnswerRecordController {
    @Autowired
    private AnswerRecordService answerRecordService;

    /**
     * 添加
     */
    @PostMapping("v1")
    public Integer addAnswerRecord(@RequestBody AnswerRecord answerRecord) {
        return answerRecordService.addAnswerRecord(answerRecord);
    }

    @DeleteMapping("v1/{id}")
    public Integer delAnswerRecordById(@PathVariable Integer id) {
        return answerRecordService.delAnswerRecordById(id);
    }

    @DeleteMapping("v1")
    public Integer delAnswerRecordByIds(@RequestBody List<Integer> ids) {
        return answerRecordService.delAnswerRecordByIds(ids);
    }

    @PutMapping("v1")
    public Integer updAnswerRecord(@RequestBody AnswerRecord answerRecord) {
        return answerRecordService.updAnswerRecord(answerRecord);
    }

    @GetMapping("search")
    public PageInfo<AnswerRecordVO> search(
            @RequestBody AnswerRecordDTO answerRecordDTO,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) throws BizException {
        return answerRecordService.search(answerRecordDTO, pageNum, pageSize);
    }

    //查询用户答题记录并返回
    @GetMapping("v1/rec/{userId}")
    public List<AnswerRecord> findAnswerRecordByUserId(@PathVariable Integer userId) {
        return answerRecordService.findAnswerRecordByUserId(userId);
    }

    /**
     * 开始答题接口
     */
    @PostMapping("start/{AnswerRecordId}")
    public ResponseEntity<String> startQuestion(@PathVariable Integer AnswerRecordId) {
        answerRecordService.startAnswer(AnswerRecordId);
        return ResponseEntity.ok("答题开始！");
    }

    /**
     * 判断
     * @param answerRecordDTO
     * @return
     */
    @PostMapping("judge")
    public AnswerRecordVO judgeAndSaveAnswer(AnswerRecordDTO answerRecordDTO) {
        return answerRecordService.judgeAndSaveAnswer(answerRecordDTO);
    }

    @PostMapping("submit/{AnswerRecordId}")
    public ResponseEntity<String> submitAnswer(@PathVariable Integer AnswerRecordId,
                                               @RequestBody String answerGiven) {
        answerRecordService.submitAnswer(AnswerRecordId, answerGiven);
        return ResponseEntity.ok("答题提交成功！");
    }

    /**
     * 实时同步答题时间
     */
    @PostMapping("sync-time")
    public ResponseEntity<String> syncTimeSpent(
            @RequestParam Integer answerRecordId,
            @RequestParam Integer timeSpent) {
        // 可选：将时间直接写入数据库或日志
        log.info("用户 {} 同步用时：{} 秒", answerRecordId, timeSpent);
        return ResponseEntity.ok("用时同步成功！");
    }

}

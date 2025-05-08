package com.llm.llm_knowledge.controller;

import com.llm.llm_knowledge.service.HBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/hbase")
public class HBaseController {

    @Autowired
    private HBaseService hBaseService;

    @GetMapping("/get")
    public ResponseEntity<Object> get(@RequestParam String table,
                                      @RequestParam String row,
                                      @RequestParam(required = false) String family,
                                      @RequestParam(required = false) String column) throws Exception {
        Object value = hBaseService.getValue(table, row, family, column);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/scan")
    public ResponseEntity<?> scanTable(@RequestParam String table) {
        try {
            List<Map<String, Object>> result = hBaseService.scanTable(table);
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Scan failed: " + e.getMessage());
        }
    }
}


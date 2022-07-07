package com.example.springstudy.controller;

import com.example.springstudy.model.GetModel;
import com.example.springstudy.model.JsonModel;
import com.example.springstudy.model.ResponseModel;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/model")
    public String get(GetModel model) {
        log.info("GET 요청 데이터 = {}", model);
        return "SUCCESS";
    }

    @PostMapping("/model")
    public String post(@RequestBody JsonModel model) {
        log.info("POST 요청 데이터 = {}", model);
        return "SUCCESS";
    }

    @GetMapping("/response")
    public ResponseModel responseModel() {
        return new ResponseModel("test", LocalDateTime.of(2022, 1, 1, 10, 0, 0));
    }
}

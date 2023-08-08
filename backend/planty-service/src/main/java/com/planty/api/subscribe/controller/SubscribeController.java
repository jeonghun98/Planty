package com.planty.api.subscribe.controller;

import com.planty.api.consulting.response.UserConsultingResponse;
import com.planty.api.subscribe.response.UserSubscribeDatailResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.planty.api.subscribe.response.UserSubscribeResponse;
import com.planty.api.subscribe.service.SubscribeService;
import static com.planty.common.util.LogCurrent.*;

@RestController
@Slf4j
@RequestMapping("/api/subscribes")
@RequiredArgsConstructor
@Api
public class SubscribeController {
    private final SubscribeService subscribeServiceImpl;
    @GetMapping
    public ResponseEntity<?> getUserSubscribeList() {

        log.info(logCurrent(getClassName(), getMethodName(), START));
        List<UserSubscribeResponse> subscribeList = subscribeServiceImpl.getUserSubscribe("ssafyDevelop");

        if (!subscribeList.isEmpty()) {
            log.info(logCurrent(getClassName(), getMethodName(), END));
            return ResponseEntity.ok().body(subscribeList);
        }
        log.info(logCurrent(getClassName(), getMethodName(), END));
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/{sid}")
    public ResponseEntity<?> getUserSubscribeDetailList(@PathVariable("sid") Long sid) {

        log.info(logCurrent(getClassName(), getMethodName(), START));
        UserSubscribeDatailResponse response = subscribeServiceImpl.getUserSubscribeDetail("ssafyDevelop", sid);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> postUserSubscribe(Long spid) {

        log.info(logCurrent(getClassName(), getMethodName(), START));
        UserSubscribeDatailResponse response = subscribeServiceImpl.getUserSubscribeDetail("ssafyDevelop", spid);
        return ResponseEntity.ok(response);
    }



}

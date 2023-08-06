package com.planty.api.consulting.controller;

import com.planty.api.consulting.response.UserConsultingResponse;
import com.planty.api.consulting.service.ConsultingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.planty.common.util.LogCurrent.*;
import static com.planty.common.util.LogCurrent.END;

@RestController
@Slf4j
@RequestMapping("/consultings")
@RequiredArgsConstructor
public class ConsultingController {
    private final ConsultingService consultingServiceImpl;
    @GetMapping
    public ResponseEntity<?> getUserConsultingList() {

        log.info(logCurrent(getClassName(), getMethodName(), START));
        List<UserConsultingResponse> consultingList = consultingServiceImpl.getUserConsultingUid(2);

        if (!consultingList.isEmpty()) {
            log.info(logCurrent(getClassName(), getMethodName(), END));
            return ResponseEntity.ok().body(consultingList);
        }
        log.info(logCurrent(getClassName(), getMethodName(), END));
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{sid}")
    public ResponseEntity<?> getUserConsultingDetailList(@PathVariable("sid") int sid) {

        log.info(logCurrent(getClassName(), getMethodName(), START));
        List<UserConsultingResponse> consultingDetailList = consultingServiceImpl.getUserConsultingDetail(sid);

        if (!consultingDetailList.isEmpty()) {
            log.info(logCurrent(getClassName(), getMethodName(), END));
            return ResponseEntity.ok().body(consultingDetailList);
        }
        log.info(logCurrent(getClassName(), getMethodName(), END));
        return ResponseEntity.noContent().build();

    }
}

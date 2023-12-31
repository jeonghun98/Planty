package com.planty.api.emergency.service;

import com.planty.api.emergency.request.EmergencyConnectionRequest;
import com.planty.api.emergency.response.ConnectionCountResponse;
import com.planty.api.emergency.response.EmergencyResponse;
import com.planty.api.emergency.response.EmergencySessionResponse;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;

import java.text.ParseException;
import java.util.List;

public interface EmergencyService {
    List<EmergencyResponse> findEmergencyList() throws ParseException;

    ConnectionCountResponse getGmCnt();

    EmergencySessionResponse initializeSession(int type) throws OpenViduJavaClientException, OpenViduHttpException, IllegalAccessException;

    String createConnection(EmergencyConnectionRequest connectionInfo) throws OpenViduJavaClientException, OpenViduHttpException, IllegalAccessException;
}

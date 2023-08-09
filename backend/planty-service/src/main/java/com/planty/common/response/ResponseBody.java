package com.planty.common.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseBody {
    Integer statusCode;
    String message;
    Object resObject;
    public static ResponseBody create(Integer statusCode, String message){
        ResponseBody body  = new ResponseBody();
        body.setMessage(message);
        body.setStatusCode(statusCode);
        return  body;
    }

    public static ResponseBody create(Integer statusCode, String message, Object responseObj){
        ResponseBody body = ResponseBody.create(statusCode, message);
        body.setResObject(responseObj);
        return  body;
    }
}
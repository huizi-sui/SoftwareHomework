package com.example.Unit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class SendMessage {
    public static JSONObject send(Object data, int code, String message) {
        JSONObject result = new JSONObject();
        if(code == StaticValue.ACCPET_CODE) {
            result.put("data", data);
        }
        result.put("code", code);
        result.put("message", message);
        result.put("data", data);
        return result;
    }
}

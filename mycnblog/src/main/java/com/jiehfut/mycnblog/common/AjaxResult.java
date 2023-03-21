package com.jiehfut.mycnblog.common;

import java.util.HashMap;

public class AjaxResult {

    /**
     * 业务执行成功的时候会返回的方法
     * 返回的数据为 data
     *
     * @param data
     * @return
     */
    public static HashMap<String, Object> Success(Object data) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "");
        result.put("data", data);
        return result;
    }

    public static HashMap<String, Object> Success(String msg, Object data) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    /**
     * 业务执行失败返回状态码和错误信息
     *
     * @param msg
     * @param code
     * @return
     */
    public static HashMap<String, Object> fail(int code, String msg) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", "");
        return result;
    }


    public static HashMap<String, Object> fail(String msg, int code, Object data) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

}

package com.rjyjy.servicehandle.utility;

import org.json.JSONException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author: 章鑫
 * @Project_name：java
 * @Name: Test
 * @date: 2021-01-14 15:17
 * @Description:
 **/
@WebServlet(name = "test", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        ResultMap resultMap;
        try {
            resultMap = myDoGet(httpServletRequest, httpServletResponse);
        } catch (JSONException e) {
            resultMap = ResultMap.fail(e.toString());
        }

//        httpServletResponse.getOutputStream().write(jsonObject.toString().getBytes());
//        httpServletResponse.flushBuffer();
        httpServletResponse.getWriter().println(resultMap);
        httpServletResponse.getWriter().close();
        System.out.println(resultMap);
    }

    public ResultMap myDoGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws JSONException {
        String UserName = httpServletRequest.getParameter("arg_user_name");
        ResultMap resultMap;
        if (UserName == null) {
            resultMap = ResultMap.fail("缺少参数！");
        } else {
            resultMap = ResultMap.success(UserName);
        }
        return resultMap;
    }
}

class ResultMap {
    private String message;
    private String code;

    public static ResultMap success(String message) {
        ResultMap resultMap = new ResultMap();
        resultMap.code = "1";
        resultMap.message = message;
        return resultMap;
    }

    public static ResultMap fail(String message) {
        ResultMap resultMap = new ResultMap();
        resultMap.code = "0";
        resultMap.message = message;
        return resultMap;
    }

    @Override
    public String toString() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("code", this.code);
        hashMap.put("message", message);
        return hashMap.toString();
    }
}
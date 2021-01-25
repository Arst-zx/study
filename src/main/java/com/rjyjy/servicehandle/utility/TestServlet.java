package com.rjyjy.servicehandle.utility;

import org.json.JSONException;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
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
        JSONObject jsonObject = null;
        try {
            jsonObject = myDoGet(httpServletRequest, httpServletResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        httpServletResponse.getOutputStream().write(jsonObject.toString().getBytes());
//        httpServletResponse.flushBuffer();
        httpServletResponse.getWriter().println(jsonObject);
        httpServletResponse.getWriter().close();
        System.out.println(jsonObject);
    }

    public JSONObject myDoGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "1");
        jsonObject.put("message", "1");
        String UserName = httpServletRequest.getParameter("arg_user_name");
        if (UserName == null) {
            jsonObject.put("code", "0");
            jsonObject.put("message", "缺少参数！");
        } else {
            jsonObject.put("message", UserName);
        }
        return jsonObject;
    }
}

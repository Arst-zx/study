package test;

import com.rjyjy.commonutils.StubServletOutputStream;
import com.rjyjy.servicehandle.utility.BaseHttpServlet;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author: 章鑫
 * @Project_name：Study
 * @Name: BaseHttpServletTest
 * @date: 2019-10-30 16:12
 * @Description:
 **/
public class BaseHttpServletTest {

    private static final String POST = "POST";
    private static final String COOKIE_TOKEN_CONTENT = "73F8C26D0B7E881C5CBA1572E8818174";
    private static final String COOKIE_TOKEN = "token";
    private static final String COOKIE_TENANTID_CONTENT = "10010";
    private static final String COOKIE_TENANTID = "tenantid";
    private static final String COOKIE_LOGINNAME_CONTENT = "zhangx511";
    private static final String COOKIE_LOGINNAME = "loginname";
    private static final String COOKIE_RLZYJSESSION_CONTENT = "BE0C13A09407285F0B5CD2C59D4F0085";
    private static final String COOKIE_RLZYJSESSION = "RLZYJSESSION";

    @Test
    public void getCookieData() throws Exception {

        BaseHttpServlet baseHttpServlet = new BaseHttpServlet();

        String httpMethod = POST;

        // 设置参数
        Map<String, String> hashMap = returnMOTMData();

        Cookie[] cookiereq = new Cookie[] {
                new Cookie(COOKIE_RLZYJSESSION, COOKIE_RLZYJSESSION_CONTENT),
                new Cookie(COOKIE_LOGINNAME, COOKIE_LOGINNAME_CONTENT),
                new Cookie(COOKIE_TENANTID, COOKIE_TENANTID_CONTENT),
                new Cookie(COOKIE_TOKEN, COOKIE_TOKEN_CONTENT) };

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(request.getCookies()).thenReturn(cookiereq);
        Mockito.doNothing().when(request).setCharacterEncoding(Mockito.anyString());
        HttpServletResponse response = mock(HttpServletResponse.class);
        Mockito.doNothing().when(response).setContentType(Mockito.anyString());
        Mockito.doNothing().when(response).setCharacterEncoding(Mockito.anyString());
        Mockito.doNothing().when(response).setHeader(Mockito.anyString(),Mockito.anyString());
        Map<String, String[]> hash = new HashMap<String, String[]>(16);
        Vector<String> v = new Vector<>();
        for (String tmpKey : hashMap.keySet()) {
            String tmpValue = hashMap.get(tmpKey);
            String[] tmpValueArr = new String[] { tmpValue };
            hash.put(tmpKey, tmpValueArr);
            v.addElement(tmpKey);
            when(request.getParameter(tmpKey)).thenReturn(tmpValue);
            String[] tmpStrArr = new String[] { tmpValue };
            when(request.getParameterValues(tmpKey)).thenReturn(tmpStrArr);
        }

        when(request.getParameterNames()).thenReturn(v.elements());
        when(request.getParameterMap()).thenReturn(hash);

        when(request.getMethod()).thenReturn(httpMethod);

        StubServletOutputStream sSOutputStream = new StubServletOutputStream();
        when(response.getOutputStream()).thenReturn(sSOutputStream);

        StringWriter writer = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(writer));

        baseHttpServlet.getCookieData(new HashMap<String, Object>(hashMap));

        //baseHttpServlet.doPost(request, response);
        sSOutputStream.printContent();

    }

    private Map<String, String> returnMOTMData(){

        Map<String, String> parsedWebData = new HashMap<>();

        parsedWebData.put("arg_tenantid", "10010");
        parsedWebData.put("arg_user_id", "0881798");
        parsedWebData.put("arg_user_name", "章鑫");
        parsedWebData.put("arg_platform_uuid", "7d5b1cee4bb811e9a2650a58c0a8036e");
        parsedWebData.put("arg_gateway_name", "网关");
        parsedWebData.put("arg_gateway_mark", "网关配置标识");
        parsedWebData.put("arg_gateway_type", "配置类别");
        parsedWebData.put("arg_component_uuid", "6e381c754ab911e99b385254008aa47d");
        parsedWebData.put("arg_rule_list", "[{\"rule_uuid\":\"123123\",\"rule_key\":\"http[0].match[0].uri.prefix\",\"rule_value\":\"baidu\"},{\"rule_uuid\":\"124124\",\"rule_key\":\"http[0].match[0].uri.prefix\",\"rule_value\":\"xiaomi\"}]");
        parsedWebData.put("arg_display_list", "[{\"key\":\"123123\",\"value\":\"http[0].match[0].uri.prefix\"},{\"key\":\"124124\",\"value\":\"http[0].match[0].uri.prefix\"}]");
        parsedWebData.put("arg_microsvc_platform_uid", "e4035e369e2c11e9bacc0a58c0a803ab");

        return parsedWebData;
    }
}
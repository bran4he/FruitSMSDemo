package integration.sms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by chundong.hcd on 2017/4/21.
 *
 * /integrationsms?phone=13045610998
 * notify when phone user get fruit assign
 *
 */
@WebServlet("/integrationsms")
public class IntegrationServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(IntegrationServlet.class);

    private static final String NOTIFY_MSG = "亲爱的用户，恭喜您收到水果啦，请到微信公众号激活手机号并领取水果。";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String phone = request.getParameter("phone");

        String content = request.getParameter("content");

        logger.info("get phone:{} and will send notify message:\n{}", phone, content);

        //调用发短信接口，发送给phone，消息内容：NOTIFY_MSG
        // TODO


    }
}

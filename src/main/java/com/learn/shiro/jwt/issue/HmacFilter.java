package com.learn.shiro.jwt.issue;

import com.learn.util.Code;
import com.learn.vo.MessageVo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HmacFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        try {
            System.out.println("HmacFilter认证");
            Subject subject = getSubject(servletRequest, servletResponse);
            String userPassword = servletRequest.getParameter("userPassword");
            String userName = servletRequest.getParameter("userName");
            UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
            subject.login(token);
            return true;
        } catch (AuthenticationException e) {
            setResponseParam((HttpServletResponse) servletResponse, Code.VALIDATE_ERROR);
            return false;
        }
    }

    private void setResponseParam(HttpServletResponse response, Code code) throws IOException {
        MessageVo status = new MessageVo(code.getStatusCode(), code.getStatusMsg());
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(status);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(jsonStr);
    }
}

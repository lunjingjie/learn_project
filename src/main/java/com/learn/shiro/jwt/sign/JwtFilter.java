package com.learn.shiro.jwt.sign;

import com.learn.util.Code;
import com.learn.vo.MessageVo;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends AccessControlFilter{
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (null != getSubject(request, response)
                && getSubject(request, response).isAuthenticated()) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("authorization");
        // boolean access = TokenUtil.verifyIsContains(token);
        System.out.println(token);
        boolean access = true;
        if(access == false){
            setResponseParam((HttpServletResponse)response, Code.UNAUTHORIZED);
        }
        return access;
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

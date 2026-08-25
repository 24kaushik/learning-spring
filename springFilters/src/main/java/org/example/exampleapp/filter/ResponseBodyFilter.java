package org.example.exampleapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        ContentCachingResponseWrapper wrapperResponse = new ContentCachingResponseWrapper(httpServletResponse);

        filterChain.doFilter(servletRequest, wrapperResponse);

        byte[] wrappedRespByteArr = wrapperResponse.getContentAsByteArray();

        String wrappedRespString = new String(wrappedRespByteArr);

        String modifiedResponse = """
                 {\s
                     "status": "success",
                     "data": %s
                 }
                \s""".formatted(wrappedRespString);

        wrapperResponse.resetBuffer();
        wrapperResponse.getWriter().write(modifiedResponse);
        wrapperResponse.copyBodyToResponse();
    }
}

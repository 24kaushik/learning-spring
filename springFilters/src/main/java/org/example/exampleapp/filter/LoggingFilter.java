package org.example.exampleapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain
    ) throws IOException, ServletException {

        System.out.println("Request received at: " + System.currentTimeMillis());

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Response sent at: " + System.currentTimeMillis());
        System.out.println("---------------------------------------------");
    }
}

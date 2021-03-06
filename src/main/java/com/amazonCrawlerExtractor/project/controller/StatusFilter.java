package com.amazonCrawlerExtractor.project.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@WebFilter("/*")
public class StatusFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(StatusFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        Instant start = Instant.now();
        try {
            chain.doFilter(req, resp);
        } finally {
            Instant finish = Instant.now();
            long time = Duration.between(start, finish).toMillis();
            // uncomment the below line to Log info and see Requests in the terminal
            //log.info("{}: {} ms ", ((HttpServletRequest) req).getRequestURI(),  time);

        }
    }

    @Override
    public void destroy() {

    }
}

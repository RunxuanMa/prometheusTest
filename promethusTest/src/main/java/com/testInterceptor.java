package com;

import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class testInterceptor implements HandlerInterceptor {


    io.micrometer.core.instrument.Counter counterTest=io.micrometer.core.instrument.Counter.builder
            ("IamYourFather")
            .register(new CompositeMeterRegistry());

    static final Gauge inprogressRequests = Gauge.build()
            .name("io_namespace_http_inprogress_requests")
            .labelNames("path", "method")
            .help("Inprogress requests.").register();

    static final Counter counter = Counter.build()
            .name("eeeeeee")
            .labelNames("eeeeeee")
            .help("eee")
            .help("eeee")
            .register();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        // 计数器+1


        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        // 计数器-1
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        inprogressRequests.labels(requestURI, method).inc();
        counter.labels("eeeeeeeeeeeeeeeeee").inc(111);
        counterTest.increment();
        //inprogressRequests.labels(requestURI, method).dec();

    }
}

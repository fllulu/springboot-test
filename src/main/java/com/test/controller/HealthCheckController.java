package com.test.controller;

import com.test.model.base.out.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HealthCheckController {


    @GetMapping("/healthcheck")
    public HttpResponse<Boolean> healthcheck() {
        return HttpResponse.success(true);
    }

    
    @GetMapping("/isalive")
    public HttpResponse<Boolean> isalive() {
        return HttpResponse.success(true);
    }

    @GetMapping("/mytest")
    public HttpResponse<Boolean> test() {
        return HttpResponse.success(true);
    }

    @GetMapping("/tests")
    public HttpResponse<Boolean> tests() {
        return HttpResponse.success(true);
    }
}

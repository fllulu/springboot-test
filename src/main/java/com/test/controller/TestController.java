package com.test.controller;

import com.test.model.base.out.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fenglu
 */
public class TestController {

    @GetMapping("/mytest")
    public HttpResponse<Boolean> test() {
        return HttpResponse.success(true);
    }

    @GetMapping("/tests")
    public HttpResponse<Boolean> tests() {
        return HttpResponse.success(true);
    }
}

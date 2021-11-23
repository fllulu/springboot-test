package com.test.controller;

import com.test.model.base.out.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fenglu
 */
public class TestController {

    @GetMapping("/mytest")
    public HttpResponse<Boolean> test(@RequestParam String name) {
        System.out.println(name);
        return HttpResponse.success(true);
    }

    @GetMapping("/tests")
    public HttpResponse<Boolean> tests() {
        return HttpResponse.success(true);
    }
}

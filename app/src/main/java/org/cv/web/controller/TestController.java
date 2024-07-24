package org.cv.web.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import lombok.RequiredArgsConstructor;
import org.cv.domain.Test;
import org.cv.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    @SaCheckPermission(":hi")
    @GetMapping("hi")
    public String hi() {
        Test test = new Test();
        test.setName("test");
        test.setMark("test mark");
        test.setTags("[ 1, 2, 3 ]");
//        testService.add(test);
        List<Test> tests = testService.test();
        return "hi";
    }
    @RequestMapping()
    public String welcome() {
        return "welcome";
    }
}

package org.cv.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.cv.domain.Test;
import org.cv.mapper.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class TestService {
    private final TestMapper testMapper;

    public List<Test> test(){
        log.info("test");
        return testMapper.all();
    }

    public void add(Test test) {
        testMapper.insert(test);
    }
}

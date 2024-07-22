package org.cv.mapper;

import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.cv.domain.Test;
import org.springframework.stereotype.Repository;

@Repository
@SqlResource("test/test")
public interface TestMapper extends BaseMapper<Test> {
}

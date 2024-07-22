package org.cv.domain;

import lombok.Data;
import org.beetl.sql.annotation.entity.Table;
import org.cv.api.Base;

@Data
@Table(name = "test")
public class Test extends Base {
    private String name;
    private String mark;
    private String tags;
}

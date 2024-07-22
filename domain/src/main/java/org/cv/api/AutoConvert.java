package org.cv.api;

import org.beetl.sql.annotation.builder.AttributeConvert;
import org.beetl.sql.clazz.kit.BeanKit;
import org.beetl.sql.core.ExecuteContext;

public class AutoConvert implements AttributeConvert {
    @Override
    public Object toDb(ExecuteContext ctx, Class cls, String name, Object pojo) {
        BeanKit.setBeanProperty(pojo, ctx.getContextPara(name), name);
        return ctx.getContextPara(name);
    }
}

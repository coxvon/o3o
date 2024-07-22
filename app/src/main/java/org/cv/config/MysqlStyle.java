package org.cv.config;

import org.beetl.sql.clazz.SQLType;
import org.beetl.sql.core.ExecuteContext;
import org.beetl.sql.core.SQLExecutor;
import org.beetl.sql.core.db.MySqlStyle;

import java.time.LocalDateTime;

public class MysqlStyle extends MySqlStyle {
    @Override
    public SQLExecutor buildExecutor(ExecuteContext executeContext) {
        SQLType sqlType = executeContext.sqlSource.sqlType;
        if (sqlType.isUpdate() && !sqlType.equals(SQLType.DELETE)) {

            if (sqlType.equals(SQLType.INSERT)) {
                executeContext.setContextPara("created", LocalDateTime.now());
                executeContext.setContextPara("creator", 0L);
                executeContext.setContextPara("creatorName", "test");
            } else if (sqlType.equals(SQLType.UPDATE)) {
                executeContext.setContextPara("modified", LocalDateTime.now());
                executeContext.setContextPara("modifier", 0L);
                executeContext.setContextPara("modifierName", "test");
            }
        }
        return super.buildExecutor(executeContext);
    }
}

package org.cv.job;

import com.aizuda.snailjob.client.job.core.annotation.JobExecutor;
import com.aizuda.snailjob.client.job.core.dto.JobArgs;
import com.aizuda.snailjob.client.model.ExecuteResult;
import org.springframework.stereotype.Component;

@Component
@JobExecutor(name = "testJobExecutor")
public class TestExecutor {
    public ExecuteResult jobExecute(JobArgs jobArgs) {
        return ExecuteResult.success("测试成功");
    }
}

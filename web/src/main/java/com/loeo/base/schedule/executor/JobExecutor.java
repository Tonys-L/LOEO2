package com.loeo.base.schedule.executor;

import com.chuanghai.easypm.webapp.baseservice.schedule.core.JobData;

/**
 * 功能：job执行器接口，外部要实现这个类才能在被执行
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-11-17 19:04:27
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public interface JobExecutor {

	Object execute(JobData jobData);

}

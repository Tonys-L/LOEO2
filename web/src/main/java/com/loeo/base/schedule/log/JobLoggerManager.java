package com.loeo.base.schedule.log;

import com.chuanghai.easypm.webapp.baseservice.schedule.core.JobWrapper;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-11-20 09:38:16
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public interface JobLoggerManager {
	/**
	 * 记录任务开始
	 * @param jobWrapper
	 * @return JobLogger
	 */
	JobLogger logStart(JobWrapper jobWrapper);

	/** 记录任务结束
	 * @param jobLogger
	 * @param jobWrapper
	 * @param errMsg
	 */
	void logEnd(JobLogger jobLogger, JobWrapper jobWrapper, String errMsg);


	/** 记录任务被否决
	 * @param jobLogger
	 * @param jobWrapper
	 */
	void logVetoed(JobLogger jobLogger, JobWrapper jobWrapper);
}

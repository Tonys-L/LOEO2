package com.loeo.schedule.core.listener;


import com.loeo.schedule.core.JobWrapper;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-11-20 16:09:41
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public interface JobFinishListener {
	void onFinish(JobWrapper jobWrapper);
}

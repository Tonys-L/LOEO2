package com.loeo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.loeo.domain.entity.Test;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-05-25 16:52:06
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public interface TestDao extends BaseMapper<Test> {
	int deleteAll();
}

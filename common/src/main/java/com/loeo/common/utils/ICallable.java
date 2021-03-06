package com.loeo.common.utils;

/**
 * 功能：
 *
 * @author ：renzhongshan(zhongshan.ren@ihydt.com)
 * @create ：2017-03-08 17:06:40
 * @version ：2017 Version：1.0

 */
public interface ICallable<V> {
	V call(Object... args);
}
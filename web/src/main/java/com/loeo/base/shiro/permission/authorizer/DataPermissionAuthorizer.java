package com.loeo.base.shiro.permission.authorizer;

import com.loeo.base.shiro.permission.DataPermission;

/**
 * 功能：
 *
 * @author ：Tony.L(286269159@qq.com)
 * @create ：2018-03-10 09:16:52
 * @version ：2018 Version：1.0

 */
public interface DataPermissionAuthorizer {
	boolean authorize(DataPermission dataPermission);
}

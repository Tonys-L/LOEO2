package com.loeo.config;

import java.util.LinkedHashMap;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loeo.shiro.LoeoCredentialsMatcher;
import com.loeo.shiro.LoeoRealm;

/**
 * Created by LOEO on 2017/05/31 22:44
 */
@Configuration
public class ShiroConfig {
	@Bean
	public Realm realm(CredentialsMatcher credentialsMatcher) {
		AuthorizingRealm realm = new LoeoRealm();
		realm.setCredentialsMatcher(credentialsMatcher);
		return realm;
	}

	/**
	 * 配置自定义的密码比较器
	 */
	@Bean(name = "credentialsMatcher")
	public CredentialsMatcher credentialsMatcher() {
		return new LoeoCredentialsMatcher();
	}

	/**
	 * 通过ShiroFilterFactoryBean 初始化shiro
	 * @param securityManager
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/api/login");
		shiroFilterFactoryBean.setUnauthorizedUrl("/login.html");
		//配置访问权限
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/login.html", "anon");
		filterChainDefinitionMap.put("/logout*", "anon");
		filterChainDefinitionMap.put("/api/login", "anon");
		filterChainDefinitionMap.put("/resources/**", "anon");
		filterChainDefinitionMap.put("/**", "user");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public org.apache.shiro.mgt.SecurityManager securityManager(Realm realm) {
		return new DefaultWebSecurityManager(realm);
	}

	/**
	 *对shiro中实现了 Initializable 和 Destroyable 接口的类进行初始化和销毁工作
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 会拦截添加下列注解的方法
	 * RequiresPermissions.class, RequiresRoles.class,
	 * RequiresUser.class, RequiresGuest.class, RequiresAuthentication.class
	 * @param manager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager manager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(manager);
		return advisor;
	}
}

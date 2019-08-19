package org.java.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: 马果
 * @Date: 2019/7/28 10:16
 * @Description:
 */
@Configuration
public class ShiroConfig {

    /**
     *  shiro过滤器工厂类
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){

        //创建一个shiroFilterFactoryBean对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //指定，如果要使用的安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //指定，如果用户没有登录，发出什么请求名称，通过控制器，进行到登录界面
        shiroFilterFactoryBean.setLoginUrl("/login");

        //指定shiro如何处理拦截的请求名称
        Map filterChainDefinitionsMap = new LinkedHashMap();
        filterChainDefinitionsMap.put("/favicon.ico","anon");
        filterChainDefinitionsMap.put("/js/**","anon");
        filterChainDefinitionsMap.put("/css/**","anon");
        filterChainDefinitionsMap.put("/assets/**","anon");
        filterChainDefinitionsMap.put("/font/**","anon");
        filterChainDefinitionsMap.put("/images/**","anon");
        filterChainDefinitionsMap.put("/layui/**","anon");
        filterChainDefinitionsMap.put("/products/**","anon");
        filterChainDefinitionsMap.put("/Widget/**","anon");
        filterChainDefinitionsMap.put("/logout","logout");
        filterChainDefinitionsMap.put("/**", "authc");

        //把拦截规则，关联到ShiroFilterFactoryBean对象中
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionsMap);


        return shiroFilterFactoryBean;
    }

    /**
     * 指定安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        //创建安全管理器
        DefaultWebSecurityManager  securityManager = new DefaultWebSecurityManager();
        //指定安全管理器，通过哪一个realm类，进行认证、授权
        securityManager.setRealm(myRealm());
        //指定缓存管理器
        securityManager.setCacheManager(ehCacheManager());
        return securityManager;
    }

    /**
     * 指定realm类
     * @return
     */
    @Bean
    public MyRealm myRealm(){
        MyRealm realm = new MyRealm();
        realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }

    /***
     * 指定密码的加密规则
     * @return
     */
    @Bean
    public CredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //采用md5加密
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //设置加密次数
        hashedCredentialsMatcher.setHashIterations(5);

        return hashedCredentialsMatcher;
    }

    /**
     * 如果要shiro标记在thymeleaf页面生效，需要配置如下方法
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    /**
     * 缓存配置
     */
    @Bean
    public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
        return ehCacheManager;
    }

}

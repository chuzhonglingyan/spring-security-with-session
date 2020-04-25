package com.yuntian.ssoserver.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author guangleilei.
 * @date Created in 17:21 2019/10/18
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {



    /**
     * 添加资源拦截器 路径映射真正的目录
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }

    @Bean
    @ConditionalOnMissingBean(ClassPathTldsLoader.class)
    public ClassPathTldsLoader classPathTldsLoader() {
        return new ClassPathTldsLoader();
    }

}

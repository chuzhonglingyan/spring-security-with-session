package com.yuntian.shrio.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreeMarkerVariableConfiguration {
    @Autowired
    private freemarker.template.Configuration configuration;

    @PostConstruct
    public void setVariableConfiguration()  {
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}


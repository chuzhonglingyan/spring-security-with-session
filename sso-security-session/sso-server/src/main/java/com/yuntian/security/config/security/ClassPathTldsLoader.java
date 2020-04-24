package com.yuntian.security.config.security;

import freemarker.ext.jsp.TaglibFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * @date 2020-04-19 22:50
 * @description
 */
public class ClassPathTldsLoader {
    private static final String SECURITY_TLD = "/static/tag/security.tld";

    final private List<String> classPathTlds;

    public ClassPathTldsLoader(String... classPathTlds) {
        super();
        if(classPathTlds.length == 0){
            this.classPathTlds = Collections.singletonList(SECURITY_TLD);
        }else{
            this.classPathTlds = Arrays.asList(classPathTlds);
        }
    }

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @PostConstruct
    public void loadClassPathTlds() {
        TaglibFactory tagLibFactory = freeMarkerConfigurer.getTaglibFactory();
        if (tagLibFactory.getObjectWrapper()==null) {
            tagLibFactory.setObjectWrapper(freeMarkerConfigurer.getConfiguration().getObjectWrapper());
        }
        tagLibFactory.setClasspathTlds(classPathTlds);
    }
}
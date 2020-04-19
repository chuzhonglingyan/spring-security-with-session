package com.yuntian.security.config.security.handler;

/**
 * @author Administrator
 * @date 2020-04-19 15:30
 * @description
 */
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;

public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException {
        event.getResponse().setContentType("application/json;charset=UTF-8");
        redirectStrategy.sendRedirect(event.getRequest(), event.getResponse(), "/login");
    }
}
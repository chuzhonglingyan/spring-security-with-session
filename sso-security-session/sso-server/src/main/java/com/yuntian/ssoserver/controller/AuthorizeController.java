package com.yuntian.ssoserver.controller;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Administrator
 * @date 2020-04-25 02:06
 * @description 授权应用页面
 */
@Controller
public class AuthorizeController {

    @RequestMapping("/custom/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) request.getSession().getAttribute("authorizationRequest");
        ModelAndView view = new ModelAndView();
        view.setViewName("/auth/oauthAuthorize");
        view.addObject("clientId", authorizationRequest.getClientId());
        view.addObject("oauthAuthorize", "/oauth/authorize");
        return view;
    }

}

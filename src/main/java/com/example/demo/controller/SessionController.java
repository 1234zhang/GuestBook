package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SessionController {
    @GetMapping("/setSession")
    public Map<String,Object> setSession(HttpServletRequest request){
        Map<String, Object> sessionMap = new HashMap<>();
        request.getSession().setAttribute("map" ,request.getRequestURL());
        sessionMap.put("request url ",request.getRequestURL());
        return sessionMap;
    }
    @GetMapping("/getSession")
    public Object getSession(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId",request.getSession().getId());
        map.put("message",request.getSession().getAttribute("map"));
        return map;

    }
}

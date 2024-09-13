package kr.or.kosa.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

    @GetMapping({"","/"})
    public String home(Model model, Principal principal){
        String loginId = principal !=null ? principal.getName() : "guest";
        model.addAttribute("loginId",loginId);
        return "index";
    }
    
    /***
     * 
     * @param auth
     * @param model
     * @return
     * CustomerAccessDeniedHandler  response.sendRedirect("/exception");
     */
    @GetMapping("/exception")
    public String exception(Authentication auth , Model model){
        log.info("인증 예외 처리");
        log.info("auth : " + auth.toString());
        model.addAttribute("msg","인증거부 : " + auth.toString());
        return "/exception";
    }
    
    @GetMapping("/login")
    public String login(){
        log.info("로그인 처리");
       
        return "/login";
    }

}

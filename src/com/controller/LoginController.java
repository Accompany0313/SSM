package com.controller;


import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/user")
public class LoginController {
    //进入登录页
    @RequestMapping("/login")
    public  String loginuser(){
        return "login";
    }

    //进行判断用户是否存在
    @PostMapping("/checkuser")
    public  ModelAndView checkuser(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontext-dao.xml");
        UserService userService= (UserService) ac.getBean("userService");
        ModelAndView mav=new ModelAndView();

        if (userService.CheckUser(username,password)){
            mav.addObject("msg","登录成功");
        }
        else{
            mav.addObject("msg","登录失败");
        }
        mav.setViewName("result");
        return mav;
    }
}

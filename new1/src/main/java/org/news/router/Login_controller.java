package org.news.router;

import org.news.model.beans.User_model;
import org.news.model.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by K550jk on 2017/3/24.
 */
@Controller
public class Login_controller {
    @Autowired
    private UserService user;
    @RequestMapping(value="/admin_login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value="/do_login",method = RequestMethod.POST)
    public
    String do_login(
            @RequestParam("name") String name,
            @RequestParam("pass") String pass, HttpSession session, Map<String, Object> map){
        List<User_model> users = user.getByUNameAndUPass(name,pass);
        if(users.size()>0){
           User_model nowUser = users.get(0);
            session.setAttribute("user",nowUser);
            return "redirect:/admin/index";
        }else{
            map.put("erro","密码错误");
            return "login";
        }
    }

    @RequestMapping("/login_out")
    public void loginOut(HttpSession session, HttpServletResponse res) throws IOException {
        session.setAttribute("user",null);
        res.sendRedirect("/admin_login");
    }
    @RequestMapping("/404")
    public String NotFound(){
        return "404";
    }

}

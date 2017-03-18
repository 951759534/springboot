package org.router;
import org.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by K550jk on 2017/3/16.
 */
@Controller
public class UserView {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
package org.router;
import org.beans.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by K550jk on 2017/3/16.
 */
@RestController
public class UserJson{
   @RequestMapping(value="/do_login",method = RequestMethod.POST)
    public User do_login(@RequestBody User user){
       return user;
   }

}

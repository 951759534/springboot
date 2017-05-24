package org.news.router;


import org.hibernate.service.spi.InjectService;
import org.news.model.Service.TypeService;
import org.news.model.beans.News_model;
import org.news.model.beans.Type_model;
import org.news.model.beans.User_model;
import org.news.model.Service.NewsService;
import org.news.model.Service.UserService;
import org.news.router.beans.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by K550jk on 2017/3/21.
 */
@Controller
@RequestMapping("/admin")
public class Admin_controller {
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String admin_index(){
        return "admin_index";
    }
    @RequestMapping(value = "/changePass",method = RequestMethod.GET)
    public String admin_changePass(){
        return "admin_password";
    }
    @RequestMapping(value = "/changePass",method = RequestMethod.POST)
     public @ResponseBody String  admin_passResult(@RequestParam("pass")String pass, HttpSession session){
            User_model nowUser = (User_model) session.getAttribute("user");
            try{
                userService.updatePassById(pass,nowUser.getuId());
                nowUser.setuPass(pass);
                session.setAttribute("user",nowUser);
                return "success";
            }catch (Exception e){
               System.out.print(e);
                return "fail";
            }
    }
    @RequestMapping("/adminTip")
    public String admin_tip(@RequestParam("path") String href, Map map){
        map.put("href",href);
        return "admin_tip";
    }
    @RequestMapping("/adminName")
    public String admin_name(){
        return "admin_name";
    }

    @RequestMapping(value = "/changeName",method = RequestMethod.POST)
    public @ResponseBody String changeName(@RequestParam("name")String name,HttpSession session){
        User_model nowUser = (User_model) session.getAttribute("user");
            try{
                userService.updateNameById(name,nowUser.getuId());
                nowUser.setuName(name);
                session.setAttribute("user",nowUser);
                return "success";
            }catch (Exception e){
                System.out.print(e);
                return "fail";
            }

    }
    @Autowired
    private TypeService typeService;
    @Autowired
    private NewsService newsService;
    @RequestMapping(value = "/addNews",method = RequestMethod.GET)
    public String addNews(Map<String,Object> map){
        List<Type_model> types = typeService.getAllBydesc();
        map.put("types",types);
        return "admin_addNews";
    }
    @RequestMapping(value="/addNew",method = RequestMethod.POST)
    public @ResponseBody String do_addNews(
            @SessionAttribute("user") User_model user,
            @RequestParam("title") String title,
            @RequestParam("type") int type,
            @RequestParam("content") String content
            ){
       try{
           newsService.save(title,content,type);
           return "success";
       }catch (Exception e){
           System.out.print(e);
           return "fail";
       }
    }
    @RequestMapping(value = "/newsManage",method = RequestMethod.GET)
    public String admin_newsManage(Map map,@RequestParam(value="page"
            ,required = false,defaultValue = "1")
            Integer page,@RequestParam(value = "se",
            required = false,defaultValue = "all")
                                           String se){
        try{
            Map<String,Object> News = newsService.getNews(page,se);
            map.put("pagelist",News.get("pagelist"));
            map.put("newss",News.get("newss"));
            map.put("types",News.get("types"));
            map.put("path","/admin/newsManage");
            return "admin_newsManage";
        }catch (Exception e){
            System.out.print(e);
            return "404";
        }
    }
    @RequestMapping("/newsUpdate")
    public String adminUpdate(Map map,@RequestParam(value="page"
            ,required = false,defaultValue = "1")
            Integer page,@RequestParam(value = "se",
            required = false,defaultValue = "all")
                                          String se){
        try{
            Map<String,Object> News = newsService.getNews(page,se);
            map.put("pagelist",News.get("pagelist"));
            map.put("newss",News.get("newss"));
            map.put("types",News.get("types"));
            map.put("path","/admin/newsUpdate");
            return "admin_newsUpdate";
        }catch (Exception e){
            System.out.print(e);
            return "404";
        }
    }

    @RequestMapping(value = "/delNews",method = RequestMethod.POST)
        public @ResponseBody String  delNews(@RequestParam("nId")int nId){
       try {
                    newsService.delNewBynId(nId);
                    return "success";
       }catch (Exception e){
           System.out.println(e);
           return "fail";
       }
   }
   @RequestMapping(value="/updateNews",method = RequestMethod.POST)
    public @ResponseBody String update(
            @RequestParam("nId")int nId,
            @RequestParam("title") String title,
            @RequestParam("type")int type,
            @RequestParam("content")String content){
            try{
                newsService.updNewsByNId(title,content,type,nId);
                return "success";
            }catch (Exception e){
                System.out.println(e);
                return "fail";
            }
   }
   @RequestMapping(value="/adminType")
    public String adminType(Map map,@RequestParam(value = "page",required = false,defaultValue = "1")int page){
        int size = 5;
        int pageNum = 5;
       Map<String,Object> typePagelist = typeService.AlltypePagelist(page,size,pageNum);
       map.put("types",typePagelist.get("AllTypes"));
       map.put("pagelist",typePagelist.get("pagelist"));
       map.put("path","/admin/adminType");
       return "admin_adminType";
   }
   @RequestMapping(value = "/addType")
    public @ResponseBody String addType(@RequestParam("newType")String newType){
       try{
           if(!typeService.typeName(newType)){
               typeService.insertType(newType);
               return "success";
           }else{
               return "标题重复";
           }

       }catch (Exception e){
           System.out.print(e);
           return "fail";
       }
   }
   @RequestMapping(value = "/delType",method = RequestMethod.POST)
    public @ResponseBody String delType(@RequestParam(value = "tId")int tId){
        System.out.println(tId);
       try {
           typeService.delTypeById(tId);
           return "success";
       }catch (Exception e){
            return "fail";
       }

   }
   @RequestMapping(value = "uptType",method = RequestMethod.POST)
    public @ResponseBody String uptType(@RequestParam(value = "tId")int tId,
                                        @RequestParam(value="newType") String newType){
        try {
            if(!typeService.typeName(newType)){
            typeService.updateType(newType,tId);
            return "success";
            }else{
                return "标题重复";
            }
        }catch (Exception e){
            System.out.print(e);
            return "fail";
        }

   }
}

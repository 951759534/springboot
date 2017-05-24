package org.news.model.Service;

import org.news.model.Repository.UserRepository;
import org.news.model.beans.User_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by K550jk on 2017/4/2.
 */
@Service
public class UserService {
    @Autowired
    UserRepository user;
    @Transactional
    public void updatePassById(String pass,int uId) throws Exception{
        user.updateUPassById(pass,uId);
    }
    public List<User_model> getByUNameAndUPass(String name, String pass){
        return user.findByUNameAndUPass(name,pass);
    }
    @Transactional
    public void updateNameById(String name,int uId)throws Exception{
        user.updateUNameById(name,uId);
    }
}

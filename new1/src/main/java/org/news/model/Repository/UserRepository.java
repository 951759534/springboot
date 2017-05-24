package org.news.model.Repository;

import org.news.model.beans.User_model;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by K550jk on 2017/3/23.
 */
@Repository
public interface UserRepository extends CrudRepository<User_model,Long>{
    List<User_model> findByUNameAndUPass(String name, String pass);
    @Query(value = "update n_user set u_pass = ?1 where u_id= ?2 ", nativeQuery = true)
    @Modifying
    public void updateUPassById(String pass,int id);
    @Query(value="update n_user set u_name = ?1 where u_id = ?2 ", nativeQuery = true)
    @Modifying
    public void updateUNameById(String name,int id);


}

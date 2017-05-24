package org.news.model.Repository;

import org.news.model.beans.Type_model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by K550jk on 2017/4/3.
 */
@Repository
public interface TypeRespository extends CrudRepository<Type_model,Long>{
    public List<Type_model> findAll(Sort sort);
    public Page<Type_model> findAll(Pageable pageable);
    @Query(value="insert into n_type(t_date,t_name) values(now(),?1) ",nativeQuery = true)
    @Modifying
    public void insertType(String type);
    @Query(value = "update n_type set t_name=?1 where t_id = ?2",nativeQuery = true)
    @Modifying
    public void updateType(String tName,int tId);
    @Modifying
    @Query(value="delete from n_type where t_id = ?1",nativeQuery = true)
    public void delTypeById(int tId);

}

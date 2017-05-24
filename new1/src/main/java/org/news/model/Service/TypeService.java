package org.news.model.Service;

import org.news.model.Repository.TypeRespository;
import org.news.model.beans.Type_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by K550jk on 2017/4/3.
 */
@Service
public class TypeService {
    @Autowired
    private TypeRespository typeRespository;
    public List<Type_model> getAllBydesc(){
        Sort sort = new Sort(Sort.Direction.DESC,"tId");
        return  typeRespository.findAll(sort);
    }
    public Page<Type_model> getAllDesc(int page,int size){
        Sort sort = new Sort(Sort.Direction.DESC,"tId");
        Pageable pageable =(Pageable) new PageRequest(page-1,size,sort);
                return typeRespository.findAll(pageable);
    }
    public Map<String,Object> AlltypePagelist(int page,int size,int pages){
        Map<String,Object> AlltypePagelist = new HashMap();
        PageList pageList = new PageList(page,size,this.getAllBydesc().size(),pages);
        AlltypePagelist.put("AllTypes",this.getAllDesc(page,size));
        AlltypePagelist.put("pagelist",pageList);
       return AlltypePagelist;
    }
    @Transactional
    public void insertType(String type) throws Exception{
        typeRespository.insertType(type);
    }
    @Transactional
    public void updateType(String nName,int tId) throws Exception{
        typeRespository.updateType(nName,tId);
    }
    @Transactional
    public void delTypeById(int tId) throws Exception{
        typeRespository.delTypeById(tId);
    }

    public boolean typeName(String nName){
        return this.getAllBydesc().contains(nName);
    }
}

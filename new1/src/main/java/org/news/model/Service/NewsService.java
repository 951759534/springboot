package org.news.model.Service;

import org.news.model.Repository.NewsRepository;
import org.news.model.beans.News_model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Created by K550jk on 2017/3/21.
 */
@Service
public class NewsService {
        @Autowired
            private NewsRepository newsRepository;
        @Transactional
        public void save(String title,String content,int typeId){
            newsRepository.save(title,content,typeId);
        }
        @Transactional
        public void delNewBynId(int nId) throws Exception{
            newsRepository.delNewsByNId(nId);
        }
        public Page<News_model> getAllNewsdesc(Integer page,int size) throws Exception{
            Sort sort = new Sort(Sort.Direction.DESC,"nId");
            Pageable pages = (Pageable) new PageRequest(page,size,sort);
            return newsRepository.findAll(pages);
        }
        public int getAllNewsCount() throws Exception{
            return newsRepository.findAll().size();
        }
        public int getNewsLike(String search){
            search = "%"+search+"%";
           return newsRepository.findByNTitleLike(search).size();
        }
        public Page<News_model> getNewsLike(Integer page,int size,String search) throws Exception{
        Sort sort = new Sort(Sort.Direction.DESC,"nId");
        Pageable pages = (Pageable) new PageRequest(page,size,sort);
        search = "%"+search+"%";
        return newsRepository.findByNTitleLike(pages,search);
        }
        @Transactional
        public Map<String,Object> getNews(Integer page, String se){
            int size = 5;    //每一页分多少
            int sum;        //从数据库读到的总数
            int num = 3;
            Map News = new HashMap();
            try {
                Set types = new HashSet();
                Page<News_model> newss = null;
                if(se.equals("all")){
                    sum = this.getAllNewsCount();
                }else{
                    sum = this.getNewsLike(se);
                }
                PageList pagelist = new PageList(page,size,sum,num);
                int[] pageli = pagelist.pagelist();
                page = pagelist.getPage();
                if(se.equals("all")){
                    newss = this.getAllNewsdesc(page-1,size);
                }else{
                    newss = this.getNewsLike(page-1,size,se);
                }
                for(int i = 0;i<pageli.length;i++){
                    System.out.println(pageli[i]);
                }
                for(News_model news :newss){
                    types.add(news.getType_model());
                }
                News.put("pagelist",pagelist);
                News.put("newss",newss);
                News.put("types",types);
                return News;
            }catch (Exception e){
                    System.out.println(e);
                    return News;
            }
        }
        @Transactional
        public void updNewsByNId(String nTitle,String nContent,int tId,int nId) throws Exception{
                newsRepository.updNewsByNId(nTitle,nContent,tId,nId);
        }
}

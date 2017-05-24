package org.news.model.Repository;
import org.news.model.beans.News_model;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by K550jk on 2017/3/21.
 */
@Repository
public interface NewsRepository extends CrudRepository<News_model,Long>{


        public Page<News_model> findAll(Pageable pageable);


        public List<News_model> findByNTitleLike(String title);


        public Page<News_model> findByNTitleLike(Pageable pageable,String title);

        public List<News_model> findAll();

        @Modifying
        @Query(value = "insert into n_news(n_title,n_content,n_time,t_id) value (?1,?2,now(),?3)",nativeQuery = true)
        public void save(String title,String content,int typeId);

        @Modifying
        @Query(value = "delete from n_news where n_id=?1",nativeQuery = true)
        public void delNewsByNId(int nId);

        @Modifying
        @Query(value = "update n_news set n_title=?1,n_content=?2,t_id=?3 where n_id=?4",nativeQuery = true)
        public void updNewsByNId(String nTitle,String nContent,int tId,int nId);
}


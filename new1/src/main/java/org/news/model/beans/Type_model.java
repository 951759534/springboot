package org.news.model.beans;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by K550jk on 2017/3/22.
 */
@Entity
@Table(name="n_type")
@ToString(exclude = "news")
public class Type_model implements Serializable {
    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,name="t_id")
    private int tId;
    private String tName;

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    private Date tDate;

    public List<News_model> getNews() {
        return news;
    }

    public void setNews(List<News_model> news) {
        this.news = news;
    }

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "type_model")
    @JsonBackReference
    private List<News_model> news = new ArrayList<>();
}

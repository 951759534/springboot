package org.news.model.beans;
        import com.fasterxml.jackson.annotation.JsonBackReference;
        import org.hibernate.annotations.Type;
        import javax.persistence.*;
        import java.util.Date;
@Entity
@Table(name="n_news")

public class News_model {

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public Date getnTime() {
        return nTime;
    }

    public void setnTime(Date nTime) {
        this.nTime = nTime;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }
    @Id
    @Column(name="n_id", nullable=false,unique = true)
    private int nId;
    @Column(name="n_title", nullable=true)
    private String nTitle;
    @Column(name="n_time")
    private Date nTime;
    @Type(type = "text")
    @Column(name="n_content", nullable=true)
    private String nContent;
    @Column(name="t_id", nullable=true,insertable = false,updatable = false)
    private int tId;

    public Type_model getType_model() {
        return type_model;
    }

    public void setType_model(Type_model type_model) {
        this.type_model = type_model;
    }
    @ManyToOne
    @JoinColumn(name="t_id",foreignKey = @ForeignKey(name = "fk_News_type"))
    @JsonBackReference    //防止递归查询
    private Type_model type_model;

}






















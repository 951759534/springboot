package org.news.model.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="n_user")
public class User_model implements Serializable {

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }
    public void setuName(String uName) {
        this.uName = uName;
    }
    public String getuPass() {
        return uPass;
    }
    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uId;
    private String uName;
    private String uPass;
}

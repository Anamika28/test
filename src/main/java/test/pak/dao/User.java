package test.pak.dao;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by anamika on 7/7/17.
 */
@Component
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "user_name")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "user_cntct")
    private Integer userCntct;

    public Integer getUserCntct() {
        return userCntct;
    }

    public void setUserCntct(Integer userCntct) {
        this.userCntct = userCntct;
    }

    @Column(name = "user_address")
    private String userAddress;

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Column(name = "user_age")
    private Integer userAge;

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Column(name =  "password")
    private String password;

    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }

    @Column(name = "email_id")
    private String email_id;
    public void setEmailid(String Email)
    {
        this.email_id = Email;
    }
    public String getEmail_id()
    {
        return email_id;
    }


}

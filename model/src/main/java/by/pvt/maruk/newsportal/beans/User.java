package by.pvt.maruk.newsportal.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by yura on 15.05.2016.
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "ID")
    private int id;

    @Column(name = "USER_LOGIN", unique = true, nullable = false)
    private String userLogin;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_FIRST_NAME")
    private String userFirstName;

    @Column(name = "USER_LAST_NAME")
    private String userLastName;

    @Column(name = "USER_EMAIL")
    private String userEmail;

//    fetch.Lazy - razberis!
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    // TODO: 05.01.2017 Set заменить на List 
    private Set<New> newsSet;

    public Set<New> getNewsSet() {
        return newsSet;
    }

    public void setNewsSet(Set<New> newsSet) {
        this.newsSet = newsSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userLogin != null ? !userLogin.equals(user.userLogin) : user.userLogin != null) return false;
        return userPassword != null ? userPassword.equals(user.userPassword) : user.userPassword == null;

    }

    @Override
    public int hashCode() {
        int result = userLogin != null ? userLogin.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        return result;
    }
}
package shop.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import shop.business.LoginSessionBeanLocal;
import shop.business.model.User;

@ManagedBean(name = "loginManagedBean", eager = true)
@SessionScoped
public class LoginManagedBean implements Serializable{
    @EJB
    private LoginSessionBeanLocal loginSessionBeanLocal;
    
    private String username;
    private String password;
    private String message = "";

    public LoginManagedBean() {
    }
    
    public String login(){
        User user = loginSessionBeanLocal.login(username, password);
        if(user !=null){
                   return "index";
        }else{
            message = "Pogrešna kombinacija korisničkog imena :  " +username+" i lozinke : " + password;
            return "login";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}

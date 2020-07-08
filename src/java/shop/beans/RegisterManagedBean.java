package shop.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import shop.business.RegisterSessionBeanLocal;

@ManagedBean(name = "registerManageBean", eager = true)
@SessionScoped
public class RegisterManagedBean implements Serializable {

    @EJB
    private RegisterSessionBeanLocal registerSessionBeanLocal;

    private String username;
    private String password;
    private String name;
    private String surname;
    private String message = "";

    public RegisterManagedBean() {
    }

    //register metoda - navigacija ka drugom jsf
    public String register() {
        boolean userCreated = registerSessionBeanLocal.register(username, password, name, surname);
        if (userCreated) {
            return "index";
        } else {
            //IDEJA JE DA OVO PRIKAZEMO AKO OSTAJEMO NA ISTOJ View
            message = "Unijeto korisničko ime je već zauzeto ili imaš neku grešku";
            return "register";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Kullanıcı;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ABDULLAH
 */
@Named
@SessionScoped
public class LoginController implements Serializable{
    private Kullanıcı kullanıcı;

    public String login(){
        if (this.kullanıcı.getUsarname().equals("kullanici") && this.kullanıcı.getPassword().equals("123")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.kullanıcı);
            return "/secret/secret?faces-redirect=true";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Hatalı kullanıcı adı veya şifre")  );
            return "/login";
        }       
    }
    
    public Kullanıcı getKullanıcı() {
        if (this.kullanıcı== null) {
            this.kullanıcı=new Kullanıcı();
        }
        return kullanıcı;
    }

    public void setKullanıcı(Kullanıcı kullanıcı) {
        this.kullanıcı = kullanıcı;
    }
    
}

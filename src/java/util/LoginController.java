/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.üyeDAO;
import entity.üye;
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
    private üyeDAO udao;
    private üye uye;

    public String login(){
        uye = getUdao().girisYap(this.uye.getEmail(), this.uye.getSifre());
        if (this.uye != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.uye);
            return "/temp";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("HatalÄ± kullanÄ±cÄ± adÄ± veya ÅŸifre")  );
            return "/index";
        }       
    }

    public üyeDAO getUdao() {
        return udao == null ? udao = new üyeDAO() : udao;
    }

    public üye getUye() {
        return uye == null ? uye = new üye() : uye;
    }

    public void setUye(Ãœye uye) {
        this.uye = uye;
    }
    
 
}

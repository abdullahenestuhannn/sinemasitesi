/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ABDULLAH
 */
public class Kullanıcı {
    private String usarname;
    private String password;

    @Override
    public String toString() {
        return "Kullan\u0131c\u0131{" + "usarname=" + usarname + ", password=" + password + '}';
    }

    public String getUsarname() {
        return usarname;
    }

    public void setUsarname(String usarname) {
        this.usarname = usarname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}

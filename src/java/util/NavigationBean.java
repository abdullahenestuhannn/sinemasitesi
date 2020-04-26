/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ABDULLAH
 */
@Named
@RequestScoped
public class NavigationBean implements Serializable{
    public String page(String p){
        return "/module/"+p+"/"+p+"?faces-redirct=true";       
    }
     public String pages(String a){
        return "/module/"+a+"/"+a+"?faces-redirct=true";       
    }
     public String pagess(String f){
        return "/module/"+f+"/"+f+"?faces-redirct=true";       
    }
     
     public String pagesss(String b){
        return "/module/"+b+"/"+b+"?faces-redirct=true";       
    }
      public String pagessss(String c){
        return "/module/"+c+"/"+c+"?faces-redirct=true";       
    }
     public String pagesssss(String d){
        return "/module/"+d+"/"+d+"?faces-redirct=true";       
    }
      public String pagessssss(String e){
        return "/module/"+e+"/"+e+"?faces-redirct=true";       
    }
       public String pagessssssss(String h){
        return "/module/"+h+"/"+h+"?faces-redirct=true";       
    }
     public String pagesssssss(String g){
        return "/module/"+g+"/"+g+"?faces-redirct=true";       
    }
      public String pagesssssssss(String i){
        return "/module/"+i+"/"+i+"?faces-redirct=true";       
    }
    
}

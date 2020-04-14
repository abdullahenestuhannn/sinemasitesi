    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.YonetmenDAO;
import entity.Yonetmen;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author POLAT
 */
@FacesConverter("yonetmenConverter")
public class YonetmenConverter implements Converter{

    private YonetmenDAO yonetmenDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getYonetmenDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Yonetmen y=(Yonetmen) arg2;
        return y.getYonetmen_id().toString();
    }

    public YonetmenDAO getYonetmenDAO() {
         if (this.yonetmenDAO==null) 
            this.yonetmenDAO=new YonetmenDAO();
        return yonetmenDAO;
    }
    
}

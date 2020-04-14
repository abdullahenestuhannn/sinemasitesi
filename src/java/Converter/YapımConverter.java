    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.YapımDAO;
import entity.Yapım;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author POLAT
 */
@FacesConverter("yapımConverter")
public class YapımConverter implements Converter{

    private YapımDAO yapımDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getYapımDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Yapım y=(Yapım) arg2;
        return y.getYapım_id().toString();
    }

    public YapımDAO getYapımDAO() {
         if (this.yapımDAO==null) 
            this.yapımDAO=new YapımDAO();
        return yapımDAO;
    }
    
}

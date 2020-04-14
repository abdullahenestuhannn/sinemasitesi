    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.OyuncuDAO;
import entity.Oyuncu;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ABDULLAH
 */
@FacesConverter("oyuncuConverter")
public class OyuncuConverter implements Converter{

    private OyuncuDAO oyuncuDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getOyuncuDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Oyuncu y=(Oyuncu) arg2;
        return y.getOyuncu_id().toString();
    }

    public OyuncuDAO getOyuncuDAO() {
         if (this.oyuncuDAO==null) 
            this.oyuncuDAO=new OyuncuDAO();
        return oyuncuDAO;
    }
    
}

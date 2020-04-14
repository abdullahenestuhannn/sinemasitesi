    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.DilDAO;
import entity.Dil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ABDULLAH
 */
@FacesConverter("dilConverter")
public class DilConverter implements Converter{

    private DilDAO dilDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getDilDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Dil y=(Dil) arg2;
        return y.getDil_id().toString();
    }

    public DilDAO getDilDAO() {
         if (this.dilDAO==null) 
            this.dilDAO=new DilDAO();
        return dilDAO;
    }
    
}

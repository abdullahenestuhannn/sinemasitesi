/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.TürDAO;
import entity.Tür;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ozan
 */
@FacesConverter("türConverter")
public class TürConverter implements Converter{

    private TürDAO türDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTürDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Tür t=(Tür) arg2;
        return t.getTür_id().toString();
    }

    public TürDAO getTürDAO() {
        if (this.türDAO==null) 
            this.türDAO=new TürDAO();
        return türDAO;
    }
    
}

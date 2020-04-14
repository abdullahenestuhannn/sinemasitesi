    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import dao.SinemaSalonuDAO;
import entity.SinemaSalonu;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Onur
 */
@FacesConverter("sinemasalonuConverter")
public class SinemaSalonuConverter implements Converter{

    private SinemaSalonuDAO sinemasalonuDAO;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getSinemaSalonuDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        SinemaSalonu y=(SinemaSalonu) arg2;
        return y.getSinemasalonu_id().toString();
    }

    public SinemaSalonuDAO getSinemaSalonuDAO() {
         if (this.sinemasalonuDAO==null) 
            this.sinemasalonuDAO=new SinemaSalonuDAO();
        return sinemasalonuDAO;
    }
    
}

package com.gestionTournoi.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.gestionTournoi.metiers.Rencontre;
import com.primefaces.perso.ThemeService;
 
@FacesConverter("themeConverter")
public class ThemeConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeRencontre1");
                
                System.out.println("value de String" + value);
                return service.getRencontres().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
        	System.out.println("valeur Object : " + String.valueOf(((Rencontre) object).getId()));
            return String.valueOf(((Rencontre) object).getId());
        }
        else {
            return null;
        }
    }   
} 

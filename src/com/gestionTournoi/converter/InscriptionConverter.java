package com.gestionTournoi.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.gestionTournoi.metiers.Inscription;
import com.primefaces.perso.ListeInscrits;
 
@FacesConverter("inscriptionConverter")
public class InscriptionConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	ListeInscrits service = (ListeInscrits) fc.getExternalContext().getApplicationMap().get("listeInscrits");
                
                System.out.println("value de String " + value);
                
                return service.getInscrits().get(Integer.parseInt("0"));
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
        	//System.out.println("valeur Object : " + String.valueOf(((Inscription) object).getId()));
            return null; //String.valueOf(((Inscription) object).getId());
        }
        else {
            return null;
        }
    }   
} 

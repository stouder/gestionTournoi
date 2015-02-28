package com.gestionTournoi.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.gestionTournoi.metiers.Rencontre;
import com.primefaces.perso.ListeRencontres;

@FacesConverter(value="rencontreConverter")
public class RencontreConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				
				ListeRencontres service = (ListeRencontres) fc.getExternalContext().getApplicationMap().get("listeRencontres");
				
				Rencontre rencontre = null;
				int val = Integer.parseInt(value);
				System.out.println("valeur index " + val);
				
				for(Rencontre r:service.getRencontres()){
					
					if(r.getId() == val){
						System.out.println("id rencontre : " + r.getId());
						System.out.println("Nom de la rencontre : " + r.getNom());
						rencontre = r;
						break;
					}	
				}
								
				return rencontre;
					
				
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Conversion Error",
						"Not a valid theme."));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			System.out.println(String.valueOf(((Rencontre) object).getNom()));
			return String.valueOf(((Rencontre) object).getId());	
		} else {
			return null;
		}
	}
}

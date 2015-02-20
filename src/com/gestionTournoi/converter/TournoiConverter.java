package com.gestionTournoi.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.gestionTournoi.metiers.Rencontre;
import com.gestionTournoi.metiers.Tournoi;
import com.primefaces.perso.ListeTournois;

@FacesConverter(value="tournoiConverter")
public class TournoiConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				
				ListeTournois service = (ListeTournois) fc.getExternalContext().getApplicationMap().get("listeTournois");
				
				Tournoi tournoi = null;
				int val = Integer.parseInt(value);
				System.out.println("valeur index " + val);
				System.out.println("Tournoi " + service.getTournois());
				for(Tournoi t:service.getTournois()){
					
					if(t.getId() == val){
						//System.out.println("id rencontre : " + r.getId());
						//System.out.println("Nom de la rencontre : " + r.getNom());
						//rencontre = r;
						tournoi = t;
						break;
					}	
				}
								
				return tournoi;
					
				
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
			System.out.println(String.valueOf(((Tournoi) object).getNom()));
			return String.valueOf(((Tournoi) object).getId());	
		} else {
			return null;
		}
	}
}

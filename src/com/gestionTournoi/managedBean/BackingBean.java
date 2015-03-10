package com.gestionTournoi.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class BackingBean {
	
	private HtmlCommandButton commandButton;
	
	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}
	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}
	
	public void doProcess(){
		if(this.commandButton.getValue().equals("deconnecter")){
			System.out.println("Yes");
			this.commandButton.setValue("connecter");
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			final HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			request.getSession(false).invalidate();
			
		}else{
			System.out.println("No");
			this.commandButton.setValue("deconnecter");
		}
		
	}
	
}

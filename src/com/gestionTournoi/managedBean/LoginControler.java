package com.gestionTournoi.managedBean;



import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 
@ManagedBean
@SessionScoped
public class LoginControler
{
 
	private static final String SECURITY_LOGIN = "/j_security_check/";
	
//	private static final String SECURITY_LOGIN = "/test/test.xhtml";
    private static final String SECURITY_LOGOUT = "/j_security_logout";
 
    public String getUser()
    {  
        return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }
 
    public boolean isInRole(String role)
    {  
        return FacesContext.getCurrentInstance().getExternalContext().isUserInRole(role);
    }
 
 
    private RequestDispatcher getDispatcher(ExternalContext ctx, String url)
    {   
        return ((ServletRequest) ctx.getRequest()).getRequestDispatcher(url);
    }
 
    private void doForward(String url) throws ServletException, IOException
    {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = this.getDispatcher(ctx, url);        
        dispatcher.forward((ServletRequest) ctx.getRequest(), (ServletResponse) ctx.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
    }
 
    public String doLogin() throws IOException, ServletException
    {
        System.out.println("User Jass " + FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal());
    	//this.doForward(SECURITY_LOGIN);
        return null;
    }
 
    public String logOut() throws ServletException, IOException
    {
        this.doForward(SECURITY_LOGOUT);
        return null;
    }
}

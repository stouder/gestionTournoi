package com.primefaces.perso;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionTournoi.dao.RencontreDAO;
import com.gestionTournoi.metiers.Rencontre;
 
@ManagedBean(name="themeRencontre1", eager = true)
@ApplicationScoped
public class ThemeService {
     
    private List<Rencontre> rencontres;
     
    @PostConstruct
    public void init() {
 
    }
     
    public List<Rencontre> getRencontres() {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");

		Session session = sessionFactory.openSession();
		RencontreDAO rDAO = new RencontreDAO();
		rDAO.setSession(session);
		
        rencontres = new ArrayList<Rencontre>();
        rencontres.addAll(rDAO.getAll());
        
    	return rencontres;
    } 
}

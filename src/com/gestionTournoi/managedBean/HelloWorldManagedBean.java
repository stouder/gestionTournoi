package com.gestionTournoi.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="helloWorldManagedBean")
@RequestScoped
public class HelloWorldManagedBean {

       private String name;

       public String sayHelloAction()
       {
             return "/admin/test.xhtmt";
       }

        public String getName() {
             return name;
       }

       public void setName(String name) {
             this.name = name;
       }
}

package com.mashsoft.sms;

import com.sun.faces.config.ConfigureListener;
import javax.faces.webapp.FacesServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class SmsApplication {

	public static void main(String[] args) {
           // ConfigurableApplicationContext context = SpringApplication.run(ClassbookSpringApplication.class, args);

		ConfigurableApplicationContext context =SpringApplication.run(SmsApplication.class, args);
                JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		System.out.println("Sending message...");
		jmsTemplate.convertAndSend("reciever","Hello world from JMS!!!");
	}

     //  @Bean
	//public ServletRegistrationBean facesContext() {
		//FacesServlet facesServlet = new FacesServlet();
		//ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(facesServlet, "*.xhtml");
		//servletRegistrationBean.setLoadOnStartup(1);
		//return servletRegistrationBean;
	//}   
        @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }
        @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
         //   servletContext.setInitParameter("primefaces.THEME", "nova-light");
        };
    }          
     //@Bean
 // ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
      //spring boot only works if this is set
     // servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

      //registration
     // ServletRegistrationBean srb = new ServletRegistrationBean();
     // srb.setServlet(new FacesServlet());
     // srb.setUrlMappings(Arrays.asList("*.xhtml"));
      //srb.setLoadOnStartup(1);
     // return srb;
  //}
    
    
    
    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }          
}

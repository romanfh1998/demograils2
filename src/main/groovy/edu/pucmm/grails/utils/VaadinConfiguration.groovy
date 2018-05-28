package edu.pucmm.grails.utils

import com.vaadin.spring.annotation.EnableVaadin
import com.vaadin.spring.server.SpringVaadinServlet
import groovy.transform.CompileStatic
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * Created by aluis on 5/27/18.
 */
@SuppressWarnings("GroovyUnusedDeclaration")
@Configuration
@EnableVaadin
@CompileStatic
class VaadinConfiguration {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new SpringVaadinServlet(), "/*", "/VAADIN/*")
    }
}

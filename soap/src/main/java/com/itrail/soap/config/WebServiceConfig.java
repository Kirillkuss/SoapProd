package com.itrail.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
    }
 /** 
    @Bean(name = "documents")
    public DefaultWsdl11Definition defaultWsdl11Definition( XsdSchema countriesSchema ) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName( "DocumentsPort" );
        wsdl11Definition.setLocationUri( "/ws" );
        wsdl11Definition.setTargetNamespace( "com/itrail/soap/documents" );
        wsdl11Definition.setSchema( countriesSchema );
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("soap/documents/documents.xsd"));
    }

    @Bean(name = "patients")
    public DefaultWsdl11Definition defaultWsdl11DefinitionTwo( XsdSchema countriesSchema ) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName( "PatientsPort" );
        wsdl11Definition.setLocationUri( "/ws" );
        wsdl11Definition.setTargetNamespace( "com/itrail/soap/patients" );
        wsdl11Definition.setSchema( countriesSchema );
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchemaTwo() {
        return new SimpleXsdSchema(new ClassPathResource("soap/patients/patients.xsd"));
    }
    */
}

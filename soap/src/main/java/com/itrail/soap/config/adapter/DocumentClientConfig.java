package com.itrail.soap.config.adapter;
/** 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class DocumentClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.itrail.soap.xsd");
        marshaller.setMtomEnabled(true); //?
        return marshaller;
    }

    @Bean
    public DocumentClient documentClient( Jaxb2Marshaller marshaller) {
        DocumentClient client = new DocumentClient();
        client.setDefaultUri("http://localhost:8088/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
    


}*/

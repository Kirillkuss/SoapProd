package com.itrail.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

//http://localhost:8088/ws/documents.wsdl
//https://localhost:8088/

@Slf4j
@SpringBootApplication
public class SoapApplication {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				log.info( "FINISH SOAP");
			}
		});
		SpringApplication application = new SpringApplication(SoapApplication.class);
		application.setAdditionalProfiles("ssl");
		application.run(args);
		log.info( "START SOAP");
	}

}

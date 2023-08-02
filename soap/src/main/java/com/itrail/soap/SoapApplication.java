package com.itrail.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

//http://localhost:8088/ws/documents.wsdl

@Slf4j
@SpringBootApplication
public class SoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapApplication.class, args);
		log.info( "START SOAP");
	}

}

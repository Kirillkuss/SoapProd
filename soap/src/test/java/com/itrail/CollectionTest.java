package com.itrail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.itrail.soap.SoapApplication;
import com.itrail.soap.repository.JPADocumentRepository;
import java.util.stream.*;
import java.util.function.Function;
import java.util.Map;

@Disabled
@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT,
                 classes = SoapApplication.class )
public class CollectionTest {

    @Autowired
    private JPADocumentRepository jpaDocumentRepository;

    @Test
    @DisplayName("Самый популярый элемeнт в списке")
    public void testStreamMax() throws Exception{
        jpaDocumentRepository.findAll()
                             .stream()
                             .map( s -> s.getSeria() )
                             .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ))
                             .entrySet()
                             .stream()
                             .max(Map.Entry.comparingByValue())
                             .ifPresent( s -> System.out.println( "Max => " + s ));
    }

    @Test
    @DisplayName("Самый непопулярый элемeнт в списке")
    public void testStreamMin() throws Exception{
        jpaDocumentRepository.findAll()
                             .stream()
                             .map( s -> s.getSeria() )
                             .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ))
                             .entrySet()
                             .stream()
                             .min(Map.Entry.comparingByValue())
                             .ifPresent( s -> System.out.println( "Min  => " + s ));
    }
    
}

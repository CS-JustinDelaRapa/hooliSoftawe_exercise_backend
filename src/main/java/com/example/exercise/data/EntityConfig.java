package com.example.exercise.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EntityConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            EntityRepository repository
    ){
     return args -> {
       EntityModel user1 = new EntityModel(
               "Luffy",
               "become the pirate king",
               LocalDate.of(1999, Month.MAY, 5)
       );
         EntityModel user2 = new EntityModel(
                 "Zoro",
                 "be the greatest swordsman",
                 LocalDate.of(1999, Month.NOVEMBER, 11)
         );
         EntityModel user3 = new EntityModel(
                 "Sanji",
                 "find all blue",
                 LocalDate.of(2000, Month.MARCH, 2)
         );
         

         repository.saveAll(
                 List.of(user1, user2, user3)
         );
     };
    }
}

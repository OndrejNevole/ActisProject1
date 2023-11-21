package org.prisonerApp.main.entity;

import org.prisonerApp.main.Repository.PrisonerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PrisonerConfig {

    //PrisonerConfig create some test data for the database
    @Bean
    CommandLineRunner commandLineRunner(PrisonerRepository repository) {
        return  arg -> {
            prisoner Biden = new prisoner(
                    "Biden",
                    "Joe",
                    LocalDate.of(1942, 11, 20),
                    "Male",
                    "petty theft",
                    LocalDate.of(2000, 1, 1),
                    LocalDate.of(2020, 1, 1)
            );
            prisoner Trump = new prisoner(
                    "Trump",
                    "Donald",
                    LocalDate.of(1946, 6, 14),
                    "Male",
                    "vehicular manslaughter",
                    LocalDate.of(1998, 3, 11),
                    LocalDate.of(2004, 11, 7)
            );
            prisoner Obama = new prisoner(
                    "Obama",
                    "Barack",
                    LocalDate.of(1961, 8, 4),
                    "Male",
                    "tax evasion",
                    LocalDate.of(2000, 3, 2),
                    LocalDate.of(2004, 11, 7)
            );
            //Save the test data
            repository.saveAll(List.of(Biden, Trump, Obama));
        };
    }
}

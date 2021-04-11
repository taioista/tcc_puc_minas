package br.com.indtexbr.repository;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.indtexbr.domain.IndicadorStatusNorma;
import br.com.indtexbr.domain.Norma;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  
  /** 
   * @param repository
   * @return CommandLineRunner
   */
  @Bean
  CommandLineRunner initDatabase(NormaRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Norma(null, "Norma1", "Norma1", IndicadorStatusNorma.EM_VIGOR, new Date())));
      log.info("Preloading " + repository.save(new Norma(null, "Norma2", "Norma2", IndicadorStatusNorma.EM_VIGOR, new Date())));
      log.info("Preloading " + repository.save(new Norma(null, "Norma3", "Norma3", IndicadorStatusNorma.EM_VIGOR, new Date())));
      log.info("Preloading " + repository.save(new Norma(null, "Norma4", "Norma4", IndicadorStatusNorma.EM_VIGOR, new Date())));
      log.info("Preloading " + repository.save(new Norma(null, "Norma5", "Norma5", IndicadorStatusNorma.EM_VIGOR, new Date())));
    };
  }
}

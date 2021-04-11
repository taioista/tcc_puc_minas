package br.com.indtexbr.repository;

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
      log.info("Preloading " + repository.save(new Norma("ABNT NBR 15800/2009", "Norma1", IndicadorStatusNorma.EM_VIGOR)));
      log.info("Preloading " + repository.save(new Norma("ABNT 9925", "Norma2", IndicadorStatusNorma.EM_VIGOR)));
      log.info("Preloading " + repository.save(new Norma("ABNT NBR ISO 105-E06:2009", "Norma3", IndicadorStatusNorma.EM_VIGOR)));
      log.info("Preloading " + repository.save(new Norma("ABNT NBR ISO 105-G02:2009", "Norma4", IndicadorStatusNorma.EM_VIGOR)));
      log.info("Preloading " + repository.save(new Norma("105-X16:2009", "Norma5", IndicadorStatusNorma.EM_VIGOR)));
    };
  }
}

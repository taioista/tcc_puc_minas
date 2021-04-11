package br.com.indtexbr.task;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.indtexbr.service.NormaService;
import br.com.indtexbr.to.NormaTO;

@Component
public class NormaScheduledTask {

  private RestTemplate restTemplate;

  @Autowired
  private NormaService service;

  @Value("${NORMA_API_EXTERNA}")
  private String URL;

  private static final Logger log = LoggerFactory.getLogger(NormaScheduledTask.class);

  NormaScheduledTask(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  @Scheduled(fixedDelay = 5000)
  public void syncNormas() {
    updateNormasBatch();
  }

  private void updateNormasBatch() {
    try {
      String json = this.restTemplate.getForObject(URL, String.class);
      ObjectMapper om = new ObjectMapper();
      JsonNode list = om.readTree(json);
      List<NormaTO> normasResult = Arrays.asList(om.treeToValue(list, NormaTO[].class));
      this.service.updateNormasBatch(normasResult);
    } catch (RestClientException e) {
      log.error("Erro ao acessar o serviço: {}", e.getMessage());
    } catch (JsonProcessingException e) {
      log.error(e.getMessage());
    }
  }
}
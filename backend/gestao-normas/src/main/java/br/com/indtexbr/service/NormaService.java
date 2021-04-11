package br.com.indtexbr.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indtexbr.domain.Norma;
import br.com.indtexbr.repository.NormaRepository;
import br.com.indtexbr.to.NormaTO;

@Service
public class NormaService {

  @Autowired
  private NormaRepository normaRepository;

  
  /** 
   * @return List<Norma>
   */
  public List<Norma> findAll() {
    return this.normaRepository.findAll();
  }

  
  /** 
   * @param norma
   * @return Norma
   */
  public Norma save(Norma norma) {
    return this.normaRepository.saveAndFlush(norma);
  }

  /** 
   * @param id
   * @return Optional<Norma>
   */
  public Optional<Norma> findById(Long id) {
    return this.normaRepository.findById(id);
  }
  
  /** 
   * @param id
   */
  public void deleteById(Long id) {
    this.normaRepository.deleteById(id);
  }

  public void updateNormasBatch(List<NormaTO> normasResult) {
    List<Norma> normasBD = this.findAll();
    List<Norma> normasTO = this.fromTOtoEntity(normasResult);
    normasTO.stream().forEach(normaTO -> {
      Norma norma = normasBD.stream().filter(n -> n.getCodigo().equals(normaTO.getCodigo())).findFirst().orElse(null);
      if(norma == null) {
        this.save(normaTO);
      } else if(norma != null && !normaTO.equals(norma)) {
        norma.setCodigo(normaTO.getCodigo());
        norma.setDescricao(normaTO.getDescricao());
        norma.setUltimaAtualizacao(new Date());
        this.save(norma);
      }
    });
  }

  private List<Norma> fromTOtoEntity(List<NormaTO> normasTO) {
    return normasTO.stream().map(normaTO -> {
      Norma norma = new Norma(normaTO.getCodigo(), normaTO.getDescricao(), normaTO.getStatus());
      return norma;
    }).collect(Collectors.toList());
  }
}

package br.com.indtexbr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indtexbr.domain.Norma;
import br.com.indtexbr.repository.NormaRepository;

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
    return this.normaRepository.save(norma);
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
}

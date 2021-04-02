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

  public List<Norma> findAll() {
    return this.normaRepository.findAll();
  }

  public Norma save(Norma norma) {
    return this.normaRepository.save(norma);
  }

  public Optional<Norma> findById(Long id) {
    return this.normaRepository.findById(id);
  }
  
  public void deleteById(Long id) {
    this.normaRepository.deleteById(id);
  }
}

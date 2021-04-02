package br.com.indtexbr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indtexbr.domain.Norma;

@Repository
public interface NormaRepository  extends JpaRepository<Norma, Long> {
  
}

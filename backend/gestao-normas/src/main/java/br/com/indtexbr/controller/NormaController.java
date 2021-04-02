package br.com.indtexbr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indtexbr.domain.Norma;
import br.com.indtexbr.exception.NormaNotFoundException;
import br.com.indtexbr.service.NormaService;

@RestController
@RequestMapping("/api/normas")
public class NormaController {

  @Autowired
  private final NormaService service;

  public NormaController(final NormaService normaService) {
    this.service = normaService;
  }

  @GetMapping()
  List<Norma> all() {
    return service.findAll();
  }

  @PostMapping()
  Norma newNorma(@RequestBody final Norma newNorma) {
    return service.save(newNorma);
  }

  @GetMapping("/{id}")
  Norma one(@PathVariable final Long id) {
    return service.findById(id).orElseThrow(() -> new NormaNotFoundException(id));
  }

  @PutMapping("/{id}")
  Norma updateNorma(@RequestBody final Norma normaUpdate, @PathVariable final Long id) {
    return service.findById(id).map(norma -> {
      norma.setCodigo(normaUpdate.getCodigo());
      norma.setDescricao(normaUpdate.getDescricao());
      norma.setStatus(normaUpdate.getStatus());
      return service.save(norma);
     }).orElseGet(() -> {
      normaUpdate.setId(id);
       return service.save(normaUpdate);
     });
  }

  @DeleteMapping("/{id}")
  void deleteNorma(@PathVariable final Long id) {
    service.deleteById(id);
  }
}

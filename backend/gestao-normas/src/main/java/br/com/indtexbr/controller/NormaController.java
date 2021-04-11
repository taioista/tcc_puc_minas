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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/normas")
@Api(value = "Normas")
public class NormaController {

  @Autowired
  private final NormaService service;

  public NormaController(final NormaService normaService) {
    this.service = normaService;
  }

  
  /** 
   * @return List<Norma>
   */
  @ApiOperation(value = "Retorna todas as normas cadastradas")
  @GetMapping()
  public List<Norma> all() {
    return service.findAll();
  }

  
  /** 
   * @param norma
   * @return Norma
   */
  @ApiOperation(value = "Inclui uma norma")
  @PostMapping()
  public Norma incluirNorma(@RequestBody final Norma norma) {
    return service.save(norma);
  }

  
  /** 
   * @param id
   * @return Norma
   */
  @ApiOperation(value = "Retorna uma norma por Id")
  @GetMapping("/{id}")
  public Norma buscarNormaPorId(@PathVariable final Long id) {
    return service.findById(id).orElseThrow(() -> new NormaNotFoundException(id));
  }

  
  /** 
   * @param normaUpdate
   * @param id
   * @return Norma
   */
  @ApiOperation(value = "Atualiza os dados de uma norma")
  @PutMapping("/{id}")
  Norma atualizarNorma(@RequestBody final Norma normaUpdate, @PathVariable final Long id) {
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
  
  /** 
   * @param id
   */
  @ApiOperation(value = "Exclui uma norma previamente cadastrada")
  @DeleteMapping("/{id}")
  void deleteNorma(@PathVariable final Long id) {
    service.deleteById(id);
  }
}

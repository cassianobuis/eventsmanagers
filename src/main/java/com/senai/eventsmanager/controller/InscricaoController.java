package com.senai.eventsmanager.controller;


import com.senai.eventsmanager.dto.InscricaoDTO;
import com.senai.eventsmanager.repository.InscricaoRepository;
import com.senai.eventsmanager.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Inscricao")
public class InscricaoController {
    @Autowired
    private InscricaoService service;

    @GetMapping("/{id}")
    public InscricaoDTO findById(@PathVariable("id") UUID id){
        return service.findById(id);
    }
    @GetMapping
    public List<InscricaoDTO> findAll(){
        return service.findAll();
    }
    @PostMapping
    public InscricaoDTO save(
            @RequestBody  InscricaoDTO inscricaoCreateDTO) {
        return service.save(inscricaoCreateDTO);
    }
    @PutMapping("/{id}")
    public InscricaoDTO update(
            @PathVariable("id") UUID id,
            @RequestBody InscricaoDTO inscricaoCreateDTO){
        return service.update(id,inscricaoCreateDTO);
    }

    @DeleteMapping("/{id}")
public void deleteById(@PathVariable("id")UUID id){
        service.deleteById(id);
    }

}

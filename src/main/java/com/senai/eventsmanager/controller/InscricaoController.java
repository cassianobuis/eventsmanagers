package com.senai.eventsmanager.controller;


import com.senai.eventsmanager.dto.InscricaoCreateDTO;
import com.senai.eventsmanager.repository.InscricaoRepository;
import com.senai.eventsmanager.service.InscricaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/Inscricao")
public class InscricaoController {
    private InscricaoService service;

    @GetMapping("/{id}")
    public InscricaoCreateDTO findById(@PathVariable("id") UUID id){
        return service.findById(id);
    }
    @GetMapping
    public List<InscricaoCreateDTO> findAll(){
        return service.findAll();
    }
    @PostMapping
    public InscricaoCreateDTO save(
            @RequestBody  InscricaoCreateDTO inscricaoCreateDTO) {
        return service.save(inscricaoCreateDTO);
    }
    @PutMapping("/{id}")
    public InscricaoCreateDTO update(
            @PathVariable("id") UUID id,
            @RequestBody InscricaoCreateDTO inscricaoCreateDTO){
        return service.update(id,inscricaoCreateDTO);
    }

    @DeleteMapping("/{id}")
public void deleteById(@PathVariable("id")UUID id){
        service.deleteById(id);
    }

}

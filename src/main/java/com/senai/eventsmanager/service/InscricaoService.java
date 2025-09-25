package com.senai.eventsmanager.service;


import com.senai.eventsmanager.dto.InscricaoDTO;
import com.senai.eventsmanager.entity.Inscricao;
import com.senai.eventsmanager.repository.InscricaoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class InscricaoService {
    @Autowired
    private InscricaoRepository Repository;

    public InscricaoDTO findById(Long id){
        Inscricao inscricao = Repository.findById(id).orElseThrow();

        InscricaoDTO incricaoCreateDTO = toDto(inscricao);

        return incricaoCreateDTO;
    }
    //método para salvar um evento
    public InscricaoDTO save(InscricaoDTO inscricaoCreateDTO){
        Inscricao inscricao = toEntity(inscricaoCreateDTO);
        inscricao = Repository.save(inscricao);
        return toDto(inscricao);
    }
    //método para atulizar um evento
    public InscricaoDTO update(Long id, InscricaoDTO inscricaoCreateDTO){
        Inscricao inscricao = toEntity(inscricaoCreateDTO);
        inscricao.setId(id);
        inscricao = Repository.save(inscricao);
        return toDto(inscricao);
    }
    //método para deletar todos os evento
    public void deleteById(Long id){
        Repository.deleteById(id);
    }
    //metodo para listar todos os evento
    public List<InscricaoDTO> findAll(){
        List<Inscricao> inscricoes = Repository.findAll();
        List<InscricaoDTO> inscricaoCreateDTOS = new ArrayList<>();
        for (Inscricao inscricao : inscricoes) {
        inscricaoCreateDTOS.add(toDto(inscricao));
        }
        return inscricaoCreateDTOS;
    }

    public InscricaoDTO toDto(Inscricao inscricao){
        InscricaoDTO dto = new InscricaoDTO();
        BeanUtils.copyProperties(inscricao, dto );
        return dto;
    }

    public Inscricao toEntity(InscricaoDTO dto){
        Inscricao inscricao = new Inscricao();
        BeanUtils.copyProperties(dto, inscricao);
        return inscricao;
    }
}

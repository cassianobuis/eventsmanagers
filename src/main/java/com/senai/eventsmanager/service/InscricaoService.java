package com.senai.eventsmanager.service;


import com.senai.eventsmanager.dto.InscricaoCreateDTO;
import com.senai.eventsmanager.entity.Inscricao;
import com.senai.eventsmanager.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class InscricaoService {
    @Autowired
    private InscricaoRepository Repository;

    public InscricaoCreateDTO findById(UUID id){
        Inscricao inscricao = Repository.findById(id).orElseThrow();

        InscricaoCreateDTO incricaoCreateDTO = convertToDto(inscricao);

        return incricaoCreateDTO;
    }
    public InscricaoCreateDTO convertToDto(Inscricao inscricao){
        InscricaoCreateDTO inscricaoCreateDTO = new InscricaoCreateDTO();
        inscricaoCreateDTO.setDataHora(inscricao.getDataHora());
        inscricaoCreateDTO.setEvento(inscricao.getEvento());
        inscricaoCreateDTO.setUsuario(inscricao.getUsuario());
        inscricaoCreateDTO.setStatusPagamento(inscricao.getStatusPagamento());
        return inscricaoCreateDTO;
    }
    public Inscricao convertToEntity(InscricaoCreateDTO inscricaoCreateDTO){
        Inscricao inscricao = new Inscricao();
        inscricao.setDataHora(inscricaoCreateDTO.getDataHora());
        inscricao.setEvento(inscricaoCreateDTO.getEvento());
        inscricao.setUsuario(inscricaoCreateDTO.getUsuario());
        inscricao.setStatusPagamento(inscricaoCreateDTO.getStatusPagamento());
        return inscricao;
    }
}

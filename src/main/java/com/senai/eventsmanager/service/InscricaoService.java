package com.senai.eventsmanager.service;


import com.senai.eventsmanager.dto.EventoDTO;
import com.senai.eventsmanager.dto.InscricaoDTO;
import com.senai.eventsmanager.entity.Inscricao;
import com.senai.eventsmanager.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InscricaoService {
    @Autowired
    private InscricaoRepository Repository;

    public InscricaoDTO findById(UUID id){
        Inscricao inscricao = Repository.findById(id).orElseThrow();

        InscricaoDTO incricaoCreateDTO = convertToDto(inscricao);

        return incricaoCreateDTO;
    }
    //método para salvar um evento
    public InscricaoDTO save(InscricaoDTO inscricaoCreateDTO){
        Inscricao inscricao = convertToEntity(inscricaoCreateDTO);
        inscricao = Repository.save(inscricao);
        return convertToDto(inscricao);
    }
    //método para atulizar um evento
    public InscricaoDTO update(UUID id, InscricaoDTO inscricaoCreateDTO){
        Inscricao inscricao = convertToEntity(inscricaoCreateDTO);
        inscricao.setId(id);
        inscricao = Repository.save(inscricao);
        return convertToDto(inscricao);
    }
    //método para deletar todos os evento
    public void deleteById(UUID id){
        Repository.deleteById(id);
    }
    //metodo para listar todos os evento
    public List<InscricaoDTO> findAll(){
        List<Inscricao> inscricoes = Repository.findAll();
        List<InscricaoDTO> inscricaoCreateDTOS = new ArrayList<>();
        for (Inscricao inscricao : inscricoes) {
        inscricaoCreateDTOS.add(convertToDto(inscricao));
        }
        return inscricaoCreateDTOS;
    }

    public InscricaoDTO convertToDto(Inscricao inscricao){
        InscricaoDTO inscricaoCreateDTO = new InscricaoDTO();
        inscricaoCreateDTO.setDataHora(inscricao.getDataHora());
        inscricaoCreateDTO.setEvento(inscricao.getEvento());
        inscricaoCreateDTO.setUsuario(inscricao.getUsuario());
        inscricaoCreateDTO.setStatusPagamento(inscricao.getStatusPagamento());
        return inscricaoCreateDTO;
    }
    public Inscricao convertToEntity(InscricaoDTO inscricaoCreateDTO){
        Inscricao inscricao = new Inscricao();
        inscricao.setDataHora(inscricaoCreateDTO.getDataHora());
        inscricao.setEvento(inscricaoCreateDTO.getEvento());
        inscricao.setUsuario(inscricaoCreateDTO.getUsuario());
        inscricao.setStatusPagamento(inscricaoCreateDTO.getStatusPagamento());
        return inscricao;
    }
}

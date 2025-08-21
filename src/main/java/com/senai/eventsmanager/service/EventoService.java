package com.senai.eventsmanager.service;


import com.senai.eventsmanager.dto.EventoCreateDTO;
import com.senai.eventsmanager.entity.Evento;
import com.senai.eventsmanager.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EventoService {
    @Autowired
    private EventoRepository repository;

    public EventoCreateDTO findById(UUID id) {
        Evento evento = repository.findById(id).orElseThrow();

        EventoCreateDTO eventoCreateDTO = convertToDto(evento);
        return eventoCreateDTO;
    }

    public EventoCreateDTO convertToDto(Evento evento) {
        EventoCreateDTO eventoCreatDTO = new EventoCreateDTO();
        eventoCreatDTO.setNome(evento.getNome());
        eventoCreatDTO.setDescricao(evento.getDescricao());
        eventoCreatDTO.setTipo(evento.getTipo());
        eventoCreatDTO.setLocal(evento.getLocal());
        eventoCreatDTO.setData_final(evento.getData_final());
        eventoCreatDTO.setData_inicio(evento.getData_inicio());
        eventoCreatDTO.setLinkImagem(evento.getLinkImagem());
        eventoCreatDTO.setLinkEvento(evento.getLinkEvento());
        return eventoCreatDTO;
    }
    public Evento convertToEntity(EventoCreateDTO eventoCreateDTO) {
        Evento evento = new Evento();
        evento.setNome(eventoCreateDTO.getNome());
        evento.setDescricao(eventoCreateDTO.getDescricao());
        evento.setTipo(eventoCreateDTO.getTipo());
        evento.setLocal(eventoCreateDTO.getLocal());
        evento.setData_final(eventoCreateDTO.getData_final());
        evento.setData_inicio(eventoCreateDTO.getData_inicio());
        evento.setLinkImagem(eventoCreateDTO.getLinkImagem());
        evento.setLinkEvento(eventoCreateDTO.getLinkEvento());
        return evento;
    }
}

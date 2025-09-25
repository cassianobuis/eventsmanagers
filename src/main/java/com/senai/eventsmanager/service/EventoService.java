package com.senai.eventsmanager.service;


import com.senai.eventsmanager.dto.EventoDTO;
import com.senai.eventsmanager.entity.Evento;
import com.senai.eventsmanager.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventoService {
    @Autowired
    private EventoRepository repository;

    public EventoDTO findById(UUID id) {
        Evento evento = repository.findById(id).orElseThrow();

        EventoDTO eventoCreateDTO = convertToDto(evento);
        return eventoCreateDTO;
    }

    //método para salvar um evento
    public EventoDTO save(EventoDTO eventoCreateDTO) {
        Evento evento = convertToEntity(eventoCreateDTO);
        evento = repository.save(evento);
        return convertToDto(evento);
    }

    //método para atulizar um evento
    public EventoDTO update(UUID id,EventoDTO eventoCreateDTO) {
        Evento evento = convertToEntity(eventoCreateDTO);
        evento.setId(id);
        evento = repository.save(evento);
        return convertToDto(evento);
    }

    //metodo para deletar um evento
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    //metodo para listar todos os evento
    public List<EventoDTO> findAll() {
        List<Evento> eventos = repository.findAll();
        //criar lista de eventocreatedto
        List<EventoDTO> eventoCreateDTOS = new ArrayList<>();
        //criar cada evento na lista de eventos converter para dto e add um evento convertido
        for (Evento evento : eventos) {
            eventoCreateDTOS.add(convertToDto(evento));
        }
        return eventoCreateDTOS;
    }

    public EventoDTO convertToDto(Evento evento) {
        EventoDTO eventoCreatDTO = new EventoDTO();
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
    public Evento convertToEntity(EventoDTO eventoCreateDTO) {
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
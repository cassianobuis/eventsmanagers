package com.senai.eventsmanager.service;


import com.senai.eventsmanager.dto.EventoDTO;
import com.senai.eventsmanager.entity.Evento;
import com.senai.eventsmanager.repository.EventoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository repository;

    public EventoDTO findById(Long id) {
        Evento evento = repository.findById(id).orElseThrow();

        EventoDTO eventoCreateDTO = toDto(evento);
        return eventoCreateDTO;
    }




    public List<EventoDTO> calendario(String inicio, String fim){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy        ");

        LocalDateTime inicioFormatado = LocalDate.parse(inicio, formatter).atStartOfDay();
        LocalDateTime fimFormDate = LocalDate.parse(fim, formatter).atStartOfDay();

        List<Evento> eventos = repository.calendario(inicioFormatado, fimFormDate);
        List<EventoDTO> eventoCreateDTOS = new ArrayList<>();

        for(Evento evento: eventos){
            eventoCreateDTOS.add(toDto(evento));
        }

        return eventoCreateDTOS;
    }


    public EventoDTO save(EventoDTO eventoCreateDTO) {
        Evento evento = toEntity(eventoCreateDTO);
        evento = repository.save(evento);
        return toDto(evento);
    }

    public EventoDTO update(Long id,EventoDTO eventoCreateDTO) {
        Evento evento = toEntity(eventoCreateDTO);
        evento.setId(id);
        evento = repository.save(evento);
        return toDto(evento);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<EventoDTO> findAll() {
        List<Evento> eventos = repository.findAll();
        List<EventoDTO> eventoCreateDTOS = new ArrayList<>();
        for (Evento evento : eventos) {
            eventoCreateDTOS.add(toDto(evento));
        }
        return eventoCreateDTOS;
    }

    public EventoDTO toDto(Evento evento) {
        EventoDTO dto = new EventoDTO();
        BeanUtils.copyProperties(evento, dto);
        return dto;
    }
    
    public Evento toEntity(EventoDTO dto) {
        Evento evento = new Evento();
        BeanUtils.copyProperties(dto, evento);
        return evento;
    }
}
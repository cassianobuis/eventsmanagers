package com.senai.eventsmanager.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.eventsmanager.Enum.EventoEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "O nome do evento é obrigatório")
    @Size(max = 150, message = "O nome do evento deve ter no máximo 150 caracteres")
    private String nome;

    @NotBlank(message = "A descrição do evento é obrigatória")
    @Size(max = 500, message = "A descrição do evento deve ter no máximo 500 caracteres")
    private String descricao;

    @NotNull(message = "O tipo do evento é obrigatório")
    @Size(max = 50, message = "O tipo do evento deve ter no máximo 50 caracteres")
    private EventoEnum tipo;

    @NotBlank(message = "O local do evento é obrigatório")
    @Size(max = 150, message = "O local do evento deve ter no máximo 150 caracteres")
    private String local;

    @NotNull(message = "A data de início do evento é obrigatória")
    @JsonFormat(pattern = "dd/mm/yyyy HH:mm")
    private LocalDateTime dataInicio;

    @NotNull(message = "A data de término do evento é obrigatória")
    @JsonFormat(pattern = "dd/mm/yyyy HH:mm")
    private LocalDateTime dataFinal;


    private String linkEvento;
    private String linkImagem;
}

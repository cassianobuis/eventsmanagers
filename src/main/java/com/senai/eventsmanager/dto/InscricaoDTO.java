package com.senai.eventsmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.senai.eventsmanager.entity.Evento;
import com.senai.eventsmanager.entity.Usuario;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InscricaoDTO {



    @NotNull(message = "O evento é obrigatório")
    @Size(max = 50, message = "O evento deve ter no máximo 50 caracteres")
    private Evento evento;

    @NotBlank(message = "O status do pagamento é obrigatório")
    @Size(max = 50, message = "O status do pagamento deve ter no máximo 50 caracteres")
    private Usuario usuario;

    @NotNull(message = "A data e hora da inscrição é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora;

    
}

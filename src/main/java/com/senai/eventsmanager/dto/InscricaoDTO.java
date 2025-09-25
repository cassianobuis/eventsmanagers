package com.senai.eventsmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.eventsmanager.entity.Evento;
import com.senai.eventsmanager.entity.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InscricaoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull(message = "O evento é obrigatório")
    private Evento evento;

    @NotNull(message = "O status do pagamento é obrigatório")
    private Usuario usuario;

}

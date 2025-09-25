package com.senai.eventsmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioDTO {

    @NotBlank(message = "O email é obrigatório")
    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(max = 15, message = "A senha deve ter no máximo 15 caracteres")
    private String senha;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 150, message = "O nome deve ter no máximo 150 caracteres")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(max = 15, message = "O CPF deve ter no máximo 15 caracteres")
    private String cpf;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    private String telefone;

    @NotNull(message = "A data de nascimento é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;



}

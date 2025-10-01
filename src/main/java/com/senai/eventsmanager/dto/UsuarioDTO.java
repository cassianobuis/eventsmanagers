package com.senai.eventsmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.eventsmanager.Enum.UsuarioEnum;
import com.senai.eventsmanager.validation.DeveTerNumeros;

public class UsuarioDTO {


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;


    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @DeveTerNumeros
    private String senha;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 150, message = "O nome deve ter no máximo 150 caracteres")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @CPF
    private String cpf;

    @NotNull(message = "O tipo de usuário é obrigatório")
    private UsuarioEnum tipo;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    private String telefone;

    @NotNull(message = "A data de nascimento é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;



}

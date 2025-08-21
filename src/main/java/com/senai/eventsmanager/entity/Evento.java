package com.senai.eventsmanager.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity //pra dizer pro spring que isso é uma entidade
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO,generator="UUID")
    @Column(nullable = false,updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventoEnum tipo;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private LocalDateTime data_inicio;

    @Column(nullable = false)
    private LocalDateTime data_final;

    private double valor;

    private String linkEvento;

    private String linkImagem;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    //relacionamento com o objeto inscricao
    @OneToMany(mappedBy = "evento")
    private List<Inscricao> inscricoes;

    public Evento() {
    }

    public Evento(UUID id, String nome, String descricao, EventoEnum tipo, String local, LocalDateTime data_inicio, LocalDateTime data_final, double valor, String linkEvento, String linkImagem, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.local = local;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.valor = valor;
        this.linkEvento = linkEvento;
        this.linkImagem = linkImagem;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EventoEnum getTipo() {
        return tipo;
    }

    public void setTipo(EventoEnum tipo) {
        this.tipo = tipo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDateTime getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDateTime data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDateTime getData_final() {
        return data_final;
    }

    public void setData_final(LocalDateTime data_final) {
        this.data_final = data_final;
    }

    public String getLinkEvento() {
        return linkEvento;
    }

    public void setLinkEvento(String linkEvento) {
        this.linkEvento = linkEvento;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}

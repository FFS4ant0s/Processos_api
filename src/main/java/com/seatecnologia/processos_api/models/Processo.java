package com.seatecnologia.processos_api.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "processos")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroProcesso;
    private String assunto;
    private LocalDate dataAbertura;
    private String status;

    // Construtor vazio
    public Processo() {}

    // Construtor com parâmetros (opcional)
    public Processo(String numeroProcesso, String assunto, LocalDate dataAbertura, String status) {
        this.numeroProcesso = numeroProcesso;
        this.assunto = assunto;
        this.dataAbertura = dataAbertura;
        this.status = status;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroProcesso() {
        return this.numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getAssunto() {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public LocalDate getDataAbertura() {
        return this.dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

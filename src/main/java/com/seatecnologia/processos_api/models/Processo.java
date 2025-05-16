package com.seatecnologia.processos_api.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "processos")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Número do processo é obrigatório")
    @Size(min = 10, max = 50, message = "Número do processo deve ter entre 10 e 50 caracteres")
    private String numeroProcesso;
    
    @NotNull(message = "Assunto é obrigatório")
    @Size(min = 3, max = 255, message = "Assunto deve ter entre 3 e 255 caracteres")
    private String assunto;

    @NotNull(message = "Data de abertura é obrigatória")
    @PastOrPresent(message = "Data de abertura não pode ser no futuro")
    private LocalDate dataAbertura;

    @NotNull(message = "Status é obrigatório")
    @Size(min = 3, max = 20, message = "Status deve ter entre 3 e 20 caracteres")
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

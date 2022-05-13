package br.com.banco.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;

@Entity
public class Transferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "data_transferencia")
    private LocalDateTime dataTransferencia;
    private Double valor;
    private String tipo;
    @Column(name = "nome_operador_transacao")
    private String operadorTransacao;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;


    public Transferencia() {
    }

    public Transferencia(Integer id, LocalDateTime  dataTransferencia, Double valor, String tipo, String operadorTransacao, Conta conta) {
        this.id = id;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.operadorTransacao = operadorTransacao;
        this.conta = conta;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime  getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime  dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome_operador_transacao() {
        return operadorTransacao;
    }

    public void setNome_operador_transacao(String nome_operador_transacao) {
        this.operadorTransacao = nome_operador_transacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}

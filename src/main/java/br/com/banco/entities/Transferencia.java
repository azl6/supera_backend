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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "data_transferencia")
    private LocalDateTime dataTransferencia;
    private Double valor;
    private String tipo;
    private String nome_operador_transacao;
    @ManyToOne
    private Conta conta;

    public Transferencia() {
    }

    public Transferencia(Integer id, LocalDateTime  dataTransferencia, Double valor, String tipo, String nome_operador_transacao, Conta conta) {
        this.id = id;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nome_operador_transacao = nome_operador_transacao;
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "id=" + id +
                ", data_transferencia=" + dataTransferencia +
                ", valor=" + valor +
                ", tipo='" + tipo + '\'' +
                ", nome_operador_transacao='" + nome_operador_transacao + '\'' +
                ", conta=" + conta +
                '}';
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
        return nome_operador_transacao;
    }

    public void setNome_operador_transacao(String nome_operador_transacao) {
        this.nome_operador_transacao = nome_operador_transacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}

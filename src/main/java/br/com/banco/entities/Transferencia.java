package br.com.banco.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate data_transferencia;
    private Double valor;
    private String tipo;
    private String nome_operador_transacao;

    @ManyToOne
    private Conta conta;

    public Transferencia() {
    }

    public Transferencia(Integer id, LocalDate data_transferencia, Double valor, String tipo, String nome_operador_transacao, Conta conta) {
        this.id = id;
        this.data_transferencia = data_transferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nome_operador_transacao = nome_operador_transacao;
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "id=" + id +
                ", data_transferencia=" + data_transferencia +
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

    public LocalDate getData_transferencia() {
        return data_transferencia;
    }

    public void setData_transferencia(LocalDate data_transferencia) {
        this.data_transferencia = data_transferencia;
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

package br.com.banco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer id;
    private String nome_responsavel;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencia;

    public Conta() {
    }

    public Conta(Integer id, String nome_responsavel, List<Transferencia> transferencia) {
        this.id = id;
        this.nome_responsavel = nome_responsavel;
        this.transferencia = transferencia;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", nome_responsavel='" + nome_responsavel + '\'' +
                ", transferencia=" + transferencia +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public List<Transferencia> getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(List<Transferencia> transferencia) {
        this.transferencia = transferencia;
    }
}

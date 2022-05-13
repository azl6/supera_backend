package br.com.banco.entities;

import br.com.banco.dto.ContaResponseDTO;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer id;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencia;

    public Conta() {
    }

    public Conta(Integer id, String nomeResponsavel) {
        this.id = id;
        this.nomeResponsavel = nomeResponsavel;
    }

    public Conta(Integer id, String nomeResponsavel, List<Transferencia> transferencia) {
        this.id = id;
        this.nomeResponsavel = nomeResponsavel;
        this.transferencia = transferencia;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", nome_responsavel='" + nomeResponsavel + '\'' +
                ", transferencia=" + transferencia +
                '}';
    }

    public ContaResponseDTO toResponseDto(){
        return new ContaResponseDTO(id, nomeResponsavel);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public List<Transferencia> getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(List<Transferencia> transferencia) {
        this.transferencia = transferencia;
    }
}

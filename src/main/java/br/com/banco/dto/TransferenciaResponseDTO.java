package br.com.banco.dto;

import br.com.banco.entities.Conta;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

public class TransferenciaResponseDTO {

    private Integer id;
    private LocalDateTime dataTransferencia;
    private Double valor;
    private String tipo;
    private String operadorTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
}

package br.com.banco.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Filtro implements Serializable {

    private String dataInicio;
    private String dataFim;
    private String nomeOperador;

    public Filtro(String dataInicio, String dataFim, String nomeOperador) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.nomeOperador = nomeOperador;
    }

    @Override
    public String toString() {
        return "Filtro{" +
                "dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", nomeOperador='" + nomeOperador + '\'' +
                '}';
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }
}

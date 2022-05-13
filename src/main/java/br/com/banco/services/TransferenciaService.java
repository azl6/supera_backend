package br.com.banco.services;

import br.com.banco.dto.FiltroRequestDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.exceptions.ObjectNotFoundException;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> findAllByContaId(Integer id){
        //validar se conta existe
        List<Transferencia> obj = transferenciaRepository.findAllByContaId(id);
        return obj;
    }

    public List<Transferencia> findAllFiltered(FiltroRequestDTO filtro){
        List<Transferencia> obj;

        if(filtro.getDataInicio() != null && filtro.getDataFim() != null){

            LocalDateTime dataInicio = DateUtils.strToLocalDateTime(filtro.getDataInicio());
            LocalDateTime dataFim = DateUtils.strToLocalDateTime(filtro.getDataFim());

            //validar data fim e data inicio

            if(filtro.getNomeOperador() == null)
                obj = transferenciaRepository.
                        findAllByDataTransferenciaBetween(dataInicio,
                                                          dataFim);
            else
                obj = transferenciaRepository.
                        findAllByDataTransferenciaBetweenAndOperadorTransacao(dataInicio,
                                                                              dataFim,
                                                                              filtro.getNomeOperador());
        }else
            obj = transferenciaRepository.findAllByOperadorTransacao(filtro.getNomeOperador());

        if(obj.isEmpty()) throw new ObjectNotFoundException("Não foram encontradas transferências com os filtros informados");
        return obj;
    }

    public List<Transferencia> findAll(){
        return transferenciaRepository.findAll();
    }
}

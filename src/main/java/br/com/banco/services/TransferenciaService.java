package br.com.banco.services;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.utils.DateUtils;
import br.com.banco.utils.Filtro;
import org.hibernate.ObjectNotFoundException;
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
        System.out.println("id no service: " + id);
        //validar se conta existe
        List<Transferencia> obj = transferenciaRepository.findAllByContaId(id);
        System.out.println("obj retornado: " + obj);
        return obj;
    }

    public List<Transferencia> findAllFiltered(Filtro filtro){
        Optional<List<Transferencia>> obj = Optional.empty();

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

        return obj.orElseThrow(() -> new ObjectNotFoundException(1, "Não foram encontradas transferências com os filtros informados"));
    }

    public List<Transferencia> findAll(){
        return transferenciaRepository.findAll();
    }
}

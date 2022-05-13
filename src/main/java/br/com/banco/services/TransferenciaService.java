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
        Optional<List<Transferencia>> obj = transferenciaRepository.findAllByContaId(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(1, "Conta não encontrada"));
    }

    public List<Transferencia> findAllFiltered(Filtro filtro){
        Optional<List<Transferencia>> obj = Optional.empty();

        LocalDateTime dataInicio = DateUtils.strToLocalDateTime(filtro.getDataInicio());
        LocalDateTime dataFim = DateUtils.strToLocalDateTime(filtro.getDataFim());

        if(filtro.getDataInicio() != null && filtro.getDataFim() != null){
            obj = transferenciaRepository.findAllByDataTransferenciaBetween(dataInicio, dataFim);
        }

        return obj.orElseThrow(() -> new ObjectNotFoundException(1, "Não foram encontradas transferências com os filtros informados"));
    }
}

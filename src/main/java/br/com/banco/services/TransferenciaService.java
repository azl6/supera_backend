package br.com.banco.services;

import br.com.banco.dto.FiltroRequestDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.exceptions.InvalidDateException;
import br.com.banco.exceptions.NullFilterException;
import br.com.banco.exceptions.ObjectNotFoundException;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> findAllByContaId(Integer contaId){
        //validando se a conta informada existe
        validateBankAccountExists(contaId);

        List<Transferencia> obj = transferenciaRepository.findAllByContaId(contaId);
        return obj;
    }

    public List<Transferencia> findAllFiltered(FiltroRequestDTO filtro){
        //verificando se o filtro não é nulo
        validateFilterIsNotNull(filtro);

        //verificando se ambos dataFim e dataInicio foram informados
        validateStartDateAndEndDateWereInformed(filtro);

        List<Transferencia> obj = new ArrayList<>();

        //verificando os filtros passados
        if(filtro.getDataInicio() != null && filtro.getDataFim() != null){
            LocalDateTime dataInicio = DateUtils.strToLocalDateTime(filtro.getDataInicio());
            LocalDateTime dataFim = DateUtils.strToLocalDateTime(filtro.getDataFim());

            //validando se a data final é maior que a data inicial
            validateEndDateIsGreater(dataInicio, dataFim);

            //filtrando entre duas datas
            obj = transferenciaRepository.findAllByDataTransferenciaBetween(dataInicio, dataFim);

            //filtrando por data e operador caso o filtro de operador seja passado
            if(filtro.getNomeOperador() != null)
                obj = filterByOperador(obj, filtro);


        }else  //caso só seja passado o filtro de operador
            obj = filterByOperador(transferenciaRepository.findAll(), filtro);

        //caso não sejam encontradas transferências com os filtros passados
        if(obj.isEmpty()) throw new ObjectNotFoundException("Não foram encontradas transferências com os filtros informados");

        return obj;
    }

    //função para filtragem por nome do operador
    public List<Transferencia> filterByOperador(List<Transferencia> list, FiltroRequestDTO filtro){
        List<Transferencia> res = new ArrayList<>();

            for(Transferencia transferencia: list){

                //caso a operação verificada seja do tipo transferência
                if(Objects.equals(transferencia.getTipo(), "TRANSFERENCIA")){

                    //caso seja uma transferência de entrada
                    if(transferencia.getValor() > 0){
                        if(Objects.equals(transferencia.getConta().getNomeResponsavel(), filtro.getNomeOperador())){
                            res.add(transferencia);
                        }

                    //caso seja uma transferência de saída
                    }else if(transferencia.getValor() < 0){
                        if (Objects.equals(transferencia.getOperadorTransacao(), filtro.getNomeOperador())){
                            res.add(transferencia);
                        }
                    }
                }
            };
            return res;
        }

        private void validateFilterIsNotNull(FiltroRequestDTO filtro){
            if(filtro.getNomeOperador() == null &&
               filtro.getDataInicio() == null   &&
               filtro.getDataFim() == null)
                throw new NullFilterException("Não foram informados filtros");
        }

        private void validateEndDateIsGreater(LocalDateTime startDate, LocalDateTime endDate){
            if (endDate.isBefore(startDate))
                throw new InvalidDateException("A <dataInicio> informada é mais atual que a <dataFim>");
        }

        private void validateStartDateAndEndDateWereInformed(FiltroRequestDTO filtro){
            if(filtro.getDataInicio() != null && filtro.getDataFim() == null ||
               filtro.getDataFim() != null && filtro.getDataInicio() == null)
                throw new InvalidDateException("Ambos os campos <dataInicio> e <dataFim> devem ser informados");
        }

        private void validateBankAccountExists(Integer contaId){
            if(!transferenciaRepository.existsByContaId(contaId))
                throw new ObjectNotFoundException("O número da conta informada não está cadastrado");
        }

    public List<Transferencia> findAll(){
        return transferenciaRepository.findAll();
    }
}

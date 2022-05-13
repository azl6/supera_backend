package br.com.banco.repositories;

import br.com.banco.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    List<Transferencia> findByConta_Id(Integer id);

    Optional<List<Transferencia>> findAllByDataTransferenciaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
    Optional<List<Transferencia>> findAllByDataTransferenciaBetweenAndOperadorTransacao(
                                                                            LocalDateTime dataInicio,
                                                                            LocalDateTime dataFim,
                                                                            String operadorTransacao
    );
    Optional<List<Transferencia>> findAllByOperadorTransacao(String operadorTransacao);
}

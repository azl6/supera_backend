package br.com.banco.services;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

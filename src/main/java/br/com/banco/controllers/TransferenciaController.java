package br.com.banco.controllers;

import br.com.banco.entities.Transferencia;
import br.com.banco.services.TransferenciaService;
import br.com.banco.utils.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping("/{contaId}")
    public ResponseEntity<List<Transferencia>> findAllByContaId(Integer contaId){
        List<Transferencia> obj = transferenciaService.findAllByContaId(contaId);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> findAllFiltered(@RequestBody Filtro filtro){
        System.out.println(filtro);
        List<Transferencia> obj = transferenciaService.findAllFiltered(filtro);
        return ResponseEntity.ok().body(obj);
    }
}

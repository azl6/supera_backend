package br.com.banco.controllers;

import br.com.banco.dto.FiltroRequestDTO;
import br.com.banco.dto.TransferenciaResponseDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping("/{contaId}")
    public ResponseEntity<List<Transferencia>> findAllByContaId(@PathVariable Integer contaId){
        List<Transferencia> obj = transferenciaService.findAllByContaId(contaId);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> findAllFiltered(@Valid @RequestBody FiltroRequestDTO filtro){
        System.out.println(filtro);
        List<Transferencia> obj = transferenciaService.findAllFiltered(filtro);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transferencia>> findAll(){
        List<Transferencia> obj = transferenciaService.findAll();
        return ResponseEntity.ok().body(obj);
    }
}

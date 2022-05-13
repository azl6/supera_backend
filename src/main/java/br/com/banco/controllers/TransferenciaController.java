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
    public ResponseEntity<List<TransferenciaResponseDTO>> findAllByContaId(@PathVariable Integer contaId){
        List<Transferencia> obj = transferenciaService.findAllByContaId(contaId);
        List<TransferenciaResponseDTO> response = transferenciaService.listToDto(obj);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaResponseDTO>> findAllFiltered(@Valid @RequestBody FiltroRequestDTO filtro){
        List<Transferencia> obj = transferenciaService.findAllFiltered(filtro);
        List<TransferenciaResponseDTO> response = transferenciaService.listToDto(obj);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransferenciaResponseDTO>> findAll(){
        List<Transferencia> obj = transferenciaService.findAll();
        List<TransferenciaResponseDTO> response = transferenciaService.listToDto(obj);

        return ResponseEntity.ok().body(response);
    }
}

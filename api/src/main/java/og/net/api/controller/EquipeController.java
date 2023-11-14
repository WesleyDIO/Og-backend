package og.net.api.controller;

import lombok.AllArgsConstructor;
import og.net.api.exception.*;
import og.net.api.model.dto.EquipeCadastroDTO;
import og.net.api.model.entity.Equipe;
import og.net.api.service.EquipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/equipe")
public class EquipeController {

    private EquipeService equipeService;

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> buscarUm(@PathVariable Integer id){
        try {
            equipeService.buscarUm(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EquipeNaoEncontradaException e){
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nome")
    public ResponseEntity<Collection<Equipe>> buscarEquipesNome(@RequestParam String nome){
        try{
            return new ResponseEntity<>(equipeService.buscarEquipesNome(nome),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Equipe>> buscarTodos(){
        try{
            return new ResponseEntity<>(equipeService.buscarTodos(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        equipeService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Equipe> cadastrar(@RequestBody EquipeCadastroDTO equipeCadastroDTO){
        try{
            equipeService.cadastrar(equipeCadastroDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (Exception e){
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Equipe> editar(@RequestBody EquipeCadastroDTO equipeCadastroDTO){
        try {
            equipeService.editar(equipeCadastroDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (DadosNaoEncontradoException e){
            e.getMessage();
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

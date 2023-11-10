package og.net.api.controller;

import lombok.AllArgsConstructor;
import og.net.api.exception.DadosNaoEncontradoException;
import og.net.api.model.dto.PropriedadeCadastroDTO;
import og.net.api.model.entity.Propriedade;
import og.net.api.service.PropriedadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/propriedade")
public class PropriedadeController {

    private PropriedadeService propriedadeService;

    @GetMapping("/{id}")
    public ResponseEntity<Propriedade> buscarUm(@PathVariable Integer id){
        try {
            propriedadeService.buscarUm(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Propriedade>> buscarTodos(){
        try{
            return new ResponseEntity<>(propriedadeService.buscarTodos(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        propriedadeService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Propriedade> cadastrar(@RequestBody PropriedadeCadastroDTO propriedadeCadastroDTO){
        try{
            propriedadeService.cadastrar(propriedadeCadastroDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Propriedade> editar(@RequestBody PropriedadeCadastroDTO propriedadeCadastroDTO){
        try {
            propriedadeService.editar(propriedadeCadastroDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (DadosNaoEncontradoException e){
            e.getMessage();
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

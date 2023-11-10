package og.net.api.controller;

import lombok.AllArgsConstructor;
import og.net.api.exception.DadosNaoEncontradoException;
import og.net.api.exception.UsuarioInesxistenteException;
import og.net.api.exception.UsuarioJaExistenteException;
import og.net.api.model.dto.UsuarioCadastroDTO;
import og.net.api.model.entity.Usuario;
import og.net.api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUm(@PathVariable Integer id){
        try {
            usuarioService.buscarUm(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UsuarioInesxistenteException e){
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Usuario>> buscarTodos(){
        try{
            return new ResponseEntity<>(usuarioService.buscarTodos(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        usuarioService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO){
        try{
            usuarioService.cadastrar(usuarioCadastroDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (UsuarioJaExistenteException e){
            e.getMessage();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> editar(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO){
        try {
            usuarioService.editar(usuarioCadastroDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (DadosNaoEncontradoException e){
            e.getMessage();
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

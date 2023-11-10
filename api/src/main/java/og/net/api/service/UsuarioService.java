package og.net.api.service;

import lombok.AllArgsConstructor;
import og.net.api.exception.DadosNaoEncontradoException;
import og.net.api.exception.UsuarioInesxistenteException;
import og.net.api.exception.UsuarioJaExistenteException;
import og.net.api.model.dto.IDTO;
import og.net.api.model.dto.UsuarioCadastroDTO;
import og.net.api.model.entity.Usuario;
import og.net.api.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

     private UsuarioRepository usuarioRepository;

    public void buscarUm(Integer id) throws UsuarioInesxistenteException {
        if(!usuarioRepository.existsById(id)){
            throw new UsuarioInesxistenteException();
        }
        usuarioRepository.findById(id).get();
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public void deletar(Integer id){
        usuarioRepository.deleteById(id);
    }

    public void cadastrar(IDTO dto) throws UsuarioJaExistenteException {
        UsuarioCadastroDTO usuarioCadastroDTO = (UsuarioCadastroDTO) dto;
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDTO,usuario);
        if (usuarioRepository.existsById(usuario.getId())){
            throw new UsuarioJaExistenteException();
        }
        usuarioRepository.save(usuario);
    }

    public void editar(IDTO dto) throws DadosNaoEncontradoException {
        UsuarioCadastroDTO ucdto = (UsuarioCadastroDTO) dto;
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(ucdto,usuario);
        if (!usuarioRepository.existsById(usuario.getId())){
            throw new DadosNaoEncontradoException();
        }
        usuarioRepository.save(usuario);
    }
}

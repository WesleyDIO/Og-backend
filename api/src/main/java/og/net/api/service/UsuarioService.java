package og.net.api.service;

import lombok.AllArgsConstructor;
import og.net.api.model.dto.IDTO;
import og.net.api.model.dto.UsuarioCadastroDTO;
import og.net.api.model.entity.Usuario;
import og.net.api.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

     private UsuarioRepository usuarioRepository;

    public void buscarUm(Integer id){
        usuarioRepository.findById(id).get();
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public void deletar(Integer id){
        usuarioRepository.deleteById(id);
    }

    public void cadastrar(IDTO dto){
        UsuarioCadastroDTO usuarioCadastroDTO = (UsuarioCadastroDTO) dto;
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDTO,usuario);
        usuarioRepository.save(usuario);
    }

    public void editar(IDTO dto) {
        UsuarioCadastroDTO ucdto = (UsuarioCadastroDTO) dto;
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(ucdto,usuario);
        usuarioRepository.save(usuario);
    }
}

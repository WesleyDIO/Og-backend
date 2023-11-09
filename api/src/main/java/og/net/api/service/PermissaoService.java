package og.net.api.service;

import lombok.AllArgsConstructor;
import og.net.api.model.dto.IDTO;
import og.net.api.model.dto.PermissaoCadastroDTO;
import og.net.api.model.dto.UsuarioCadastroDTO;
import og.net.api.model.entity.Permissao;
import og.net.api.model.entity.Usuario;
import og.net.api.repository.PermissaoRepository;
import og.net.api.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PermissaoService {

    private PermissaoRepository permissaoRepository;

    public void buscarUm(Integer id){
        permissaoRepository.findById(id).get();
    }

    public List<Permissao> buscarTodos(){
        return permissaoRepository.findAll();
    }

    public void deletar(Integer id){
        permissaoRepository.deleteById(id);
    }

    public void cadastrar(IDTO dto){
        PermissaoCadastroDTO permissaoCadastroDTO = (PermissaoCadastroDTO) dto;
        Permissao permissao = new Permissao();
        BeanUtils.copyProperties(permissaoCadastroDTO,permissao);
        permissaoRepository.save(permissao);
    }

    public void editar(IDTO dto) {
        PermissaoCadastroDTO permissaoCadastroDTO = (PermissaoCadastroDTO) dto;
        Permissao permissao = new Permissao();
        BeanUtils.copyProperties(permissaoCadastroDTO,permissao);
        permissaoRepository.save(permissao);
    }
}

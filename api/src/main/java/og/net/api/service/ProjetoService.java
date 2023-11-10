package og.net.api.service;

import lombok.AllArgsConstructor;
import og.net.api.exception.DadosNaoEncontradoException;
import og.net.api.exception.ProjetoJaExistenteException;
import og.net.api.exception.ProjetoNaoEncontradoException;
import og.net.api.model.dto.IDTO;
import og.net.api.model.dto.ProjetoCadastroDTO;
import og.net.api.model.entity.Projeto;
import og.net.api.repository.ProjetoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetoService {

    private ProjetoRepository projetoRepository;

    public void buscarUm(Integer id) throws ProjetoNaoEncontradoException {
        if (!projetoRepository.existsById(id)){
            throw new ProjetoNaoEncontradoException();
        }
        projetoRepository.findById(id).get();
    }

    public List<Projeto> buscarTodos(){
        return projetoRepository.findAll();
    }

    public void deletar(Integer id){
        projetoRepository.deleteById(id);
    }

    public void cadastrar(IDTO dto) throws ProjetoJaExistenteException {
        ProjetoCadastroDTO projetoCadastroDTO = (ProjetoCadastroDTO) dto;
        Projeto projeto = new Projeto();
        BeanUtils.copyProperties(projetoCadastroDTO,projeto);
        if (projetoRepository.existsById(projeto.getId())){
            throw new ProjetoJaExistenteException();
        }
        projetoRepository.save(projeto);
    }

    public void editar(IDTO dto) throws DadosNaoEncontradoException {
        ProjetoCadastroDTO projetoCadastroDTO = (ProjetoCadastroDTO) dto;
        Projeto projeto = new Projeto();
        BeanUtils.copyProperties(projetoCadastroDTO,projeto);
        if (!projetoRepository.existsById(projeto.getId())){
            throw new DadosNaoEncontradoException();
        }
        projetoRepository.save(projeto);
    }
}

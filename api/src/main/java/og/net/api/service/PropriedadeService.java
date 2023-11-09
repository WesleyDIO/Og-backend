package og.net.api.service;

import lombok.AllArgsConstructor;
import og.net.api.model.dto.IDTO;
import og.net.api.model.dto.ProjetoCadastroDTO;
import og.net.api.model.entity.Propriedade;
import og.net.api.repository.PropriedadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropriedadeService {

    private PropriedadeRepository propriedadeRepository;

    public void buscarUm(Integer id){
        propriedadeRepository.findById(id).get();
    }

    public List<Propriedade> buscarTodos(){
        return propriedadeRepository.findAll();
    }

    public void deletar(Integer id){
        propriedadeRepository.deleteById(id);
    }

    public void cadastrar(IDTO dto){
        ProjetoCadastroDTO projetoCadastroDTO = (ProjetoCadastroDTO) dto;
        Propriedade propriedade = new Propriedade();
        BeanUtils.copyProperties(projetoCadastroDTO,propriedade);
        propriedadeRepository.save(propriedade);
    }

    public void editar(IDTO dto) {
        ProjetoCadastroDTO propriedadeCadastroDTO = (ProjetoCadastroDTO) dto;
        Propriedade propriedade = new Propriedade();
        BeanUtils.copyProperties(propriedadeCadastroDTO,propriedade);
        propriedadeRepository.save(propriedade);
    }
}

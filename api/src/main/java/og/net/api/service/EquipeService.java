package og.net.api.service;

import lombok.AllArgsConstructor;
import og.net.api.model.dto.EquipeCadastroDTO;
import og.net.api.model.dto.IDTO;
import og.net.api.model.entity.Equipe;
import og.net.api.repository.EquipeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class EquipeService {

    private EquipeRepository equipeRepository;

    public void buscarUm(Integer id){
        equipeRepository.findById(id).get();
    }

    public List<Equipe> buscarTodos(){
        return equipeRepository.findAll();
    }

    public void deletar(Integer id){
        equipeRepository.deleteById(id);
    }

    public void cadastrar(IDTO dto){
        EquipeCadastroDTO equipeCadastroDTO = (EquipeCadastroDTO) dto;
        Equipe equipe = new Equipe();
        BeanUtils.copyProperties(equipeCadastroDTO,equipe);
        equipeRepository.save(equipe);
    }

    public void editar(IDTO dto) {
        EquipeCadastroDTO equipeCadastroDTO = (EquipeCadastroDTO) dto;
        Equipe equipe = new Equipe();
        BeanUtils.copyProperties(equipeCadastroDTO,equipe);
        equipeRepository.save(equipe);
    }
}

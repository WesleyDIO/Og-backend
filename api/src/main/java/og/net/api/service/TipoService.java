package og.net.api.service;

import lombok.AllArgsConstructor;
import og.net.api.model.dto.IDTO;
import og.net.api.model.dto.TipoCadastroDTO;
import og.net.api.model.entity.Tipo;
import og.net.api.repository.TipoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoService {
    private TipoRepository tipoRepository;

    public void buscarUm(Integer id){
        tipoRepository.findById(id).get();
    }

    public List<Tipo> buscarTodos(){
        return tipoRepository.findAll();
    }

    public void deletar(Integer id){
        tipoRepository.deleteById(id);
    }

    public void cadastrar(IDTO dto){
        TipoCadastroDTO tipoCadastroDTO = (TipoCadastroDTO) dto;
        Tipo tipo = new Tipo();
        BeanUtils.copyProperties(tipoCadastroDTO,tipo);
        tipoRepository.save(tipo);
    }

    public void editar(IDTO dto) {
        TipoCadastroDTO tipoCadastroDTO = (TipoCadastroDTO) dto;
        Tipo tipo = new Tipo();
        BeanUtils.copyProperties(tipoCadastroDTO,tipo);
        tipoRepository.save(tipo);
    }
}

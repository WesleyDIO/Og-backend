package og.net.api.service;

import lombok.AllArgsConstructor;
import og.net.api.model.dto.IDTO;
import og.net.api.model.dto.TarefaCadastroDTO;
import og.net.api.model.entity.Tarefa;
import og.net.api.repository.TarefaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public void buscarUm(Integer id){
        tarefaRepository.findById(id).get();
    }

    public List<Tarefa> buscarTodos(){
        return tarefaRepository.findAll();
    }

    public void deletar(Integer id){
        tarefaRepository.deleteById(id);
    }

    public void cadastrar(IDTO dto){
        TarefaCadastroDTO tarefaCadastroDTO = (TarefaCadastroDTO) dto;
        Tarefa tarefa = new Tarefa();
        BeanUtils.copyProperties(tarefaCadastroDTO,tarefa);
        tarefaRepository.save(tarefa);
    }

    public void editar(IDTO dto) {
        TarefaCadastroDTO tarefaCadastroDTO = (TarefaCadastroDTO) dto;
        Tarefa tarefa = new Tarefa();
        BeanUtils.copyProperties(tarefaCadastroDTO,tarefa);
        tarefaRepository.save(tarefa);
    }
}

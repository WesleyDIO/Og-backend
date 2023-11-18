package og.net.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import og.net.api.model.entity.Permissao;
import og.net.api.model.entity.Propriedade;
import og.net.api.model.entity.Tarefa;
import og.net.api.model.entity.Usuario;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProjetoEdicaoDTO implements IDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Date data_inicio;
}

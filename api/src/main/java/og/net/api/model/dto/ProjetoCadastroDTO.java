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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoCadastroDTO implements IDTO{

    private String nome;
    private String descricao;
    private Date data_inicio;
    private Set<Tarefa> tarefas;
    private Set<Propriedade> propriedades;
    private Set<Usuario> usuarios;
    private Set<Permissao> permissao;
}

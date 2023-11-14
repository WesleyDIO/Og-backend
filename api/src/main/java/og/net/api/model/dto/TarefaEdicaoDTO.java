package og.net.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TarefaEdicaoDTO implements IDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Boolean ativo;
    private Date data_criacao;
}
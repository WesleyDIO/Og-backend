package og.net.api.model.dto;

import java.util.Date;

public class TarefaCadastroDTO implements IDTO{

    private Integer id;
    private String nome;
    private String descricao;
    private Boolean ativo;
    private Date data_criacao;
}

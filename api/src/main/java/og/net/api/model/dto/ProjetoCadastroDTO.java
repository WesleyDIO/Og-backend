package og.net.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoCadastroDTO implements IDTO{

    private String nome;
    private String descricao;
    private Date data_inicio;
}

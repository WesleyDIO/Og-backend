package og.net.api.model.dto;

import jakarta.persistence.OneToOne;
import og.net.api.model.entity.Tipo;

public class PropriedadeCadastroDTO implements IDTO{

    private String nome_propriedade;
    private Tipo tipo;
}

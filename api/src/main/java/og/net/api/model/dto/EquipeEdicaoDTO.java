package og.net.api.model.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import og.net.api.model.entity.Usuario;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipeEdicaoDTO implements IDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Set<Usuario> usuarios;
}

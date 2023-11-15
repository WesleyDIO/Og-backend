package og.net.api.model.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import og.net.api.model.entity.Projeto;
import og.net.api.model.entity.Usuario;

import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipeCadastroDTO implements IDTO {

    private String nome;
    private String descricao;
    private Set<Usuario> usuarios;
    private Projeto projeto;
}

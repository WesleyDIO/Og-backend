package og.net.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoIdClass implements Serializable {

    private Integer idProjeto;
    private Integer idUsuario;
    private Integer id;
}

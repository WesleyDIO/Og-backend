package og.net.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioIdClass implements Serializable {
    private Integer idTarefa;
    private Integer idUsuario;
    private Integer idPermissao;

}

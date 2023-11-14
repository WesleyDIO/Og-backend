package og.net.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PropriedadeEdicaoDTO implements IDTO {

    private Integer id;
    private String nome;
}

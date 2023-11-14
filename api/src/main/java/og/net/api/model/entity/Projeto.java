package og.net.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projeto")

public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Date data_inicio;

    @OneToMany
    private Set<Tarefa> tarefas;
    @OneToMany
    private Set<Propriedade> propriedades;
    @OneToMany()
    private Set<Usuario> usuarios;
    @Enumerated
    private Permissao permissao;
}

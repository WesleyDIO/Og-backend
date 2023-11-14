package og.net.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String username;
    private Date data_nascimento;
    private String email;
    private String empresa;
    private String senha;
    @OneToMany
    private Set<Tarefa> tarefas;
    @Enumerated(EnumType.STRING)
    private Permissao permissao;
}

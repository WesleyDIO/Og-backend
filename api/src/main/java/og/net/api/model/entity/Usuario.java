package og.net.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@IdClass(UsuarioIdClass.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String username;
    private Date data_nascimento;
    private String email;
    private String empresa;
    private String senha;
    @ManyToOne
    @JoinColumn(name = "idTarefa")
    private Tarefa tarefas;
    @Enumerated(EnumType.STRING)
    private Permissao permissao;
}

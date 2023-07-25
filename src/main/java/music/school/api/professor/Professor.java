package music.school.api.professor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import music.school.api.endereco.Endereco;

@Table(name="professores")
@Entity(name="Professor")
@Getter // Gerar os métodos getters com lombok..
@NoArgsConstructor // Gerar o construtor default. Sem argumentos.
@AllArgsConstructor // Construtor que recebe todos os campos.
@EqualsAndHashCode(of = "id") // Gerar o hashcode em cima do id.
public class Professor {

    public Professor(DadosCadastroProfessor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public void atualizarInformacoes(DadosAtualizacaoCadastroProfessor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }
}
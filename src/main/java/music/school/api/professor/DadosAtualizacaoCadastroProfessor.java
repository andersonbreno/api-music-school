package music.school.api.professor;

import jakarta.validation.constraints.NotNull;
import music.school.api.endereco.DadosEndereco;

public record DadosAtualizacaoCadastroProfessor(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}

package music.school.api.domain.professor;

import jakarta.validation.constraints.NotNull;
import music.school.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoCadastroProfessor(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco) {
}

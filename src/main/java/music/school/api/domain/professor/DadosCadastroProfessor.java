package music.school.api.domain.professor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import music.school.api.domain.endereco.DadosEndereco;

public record DadosCadastroProfessor(
    
    @NotBlank // Para campos String.
    String nome, 

    @NotBlank
    @Email
    String email, 

    @NotBlank
    String telefone,

    @NotNull
    Especialidade especialidade, 
    
    @NotNull @Valid 
    DadosEndereco endereco) {
}

package music.school.api.professor;

import music.school.api.endereco.Endereco;

public record DadosDetalhamentoProfessor(Long id, String nome, String email, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoProfessor(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getTelefone(), professor.getEspecialidade(), professor.getEndereco());
    }

}
